package com.example.parkingspotmanager.view.Customer.Renewal;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.domain.Renewal;
import com.example.parkingspotmanager.domain.Status;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.memorydao.RenewalDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `RenewalPresenterTest` class contains unit tests for the `RenewalPresenter` class.
 * It tests the functionality of retrieving customer information, handling deposit actions, and clearing the view.
 */
public class RenewalPresenterTest {

    private RenewalPresenter presenter;
    private RenewalViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new RenewalViewStub();
        presenter = new RenewalPresenter();
        presenter.setView(view);
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setRenewalDAO(new RenewalDAOMemory());
    }

    /**
     * Tests the retrieval of customer information by username.
     * Verifies that the correct customer is retrieved and that the username matches.
     */
    @Test
    public void testGetCustomerInfo() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);

        Customer result = presenter.findCustomerInfo("UsernameTest");
        Assert.assertNotNull(result);
        Assert.assertEquals("UsernameTest", result.getUsername());
    }

    /**
     * Tests the retrieval of the customer's username.
     * Verifies that the correct username is returned.
     */
    @Test
    public void testGetCustomerUsername() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        presenter.findCustomerInfo("UsernameTest");

        String username = presenter.getUsername();
        Assert.assertEquals("UsernameTest", username);
    }

    /**
     * Tests the deposit action for a renewal.
     * Verifies that the renewal status and amount are updated correctly after the deposit.
     */
    @Test
    public void testOnDeposit() {
        // Create a customer and save it to the DAO
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        presenter.findCustomerInfo("UsernameTest");

        // Create a renewal and set it in the presenter
        Renewal renewal = new Renewal(customer, 100.0);
        presenter.setRenewal(renewal);
        presenter.getRenewalDAO().save(renewal);
        presenter.onDeposit();

        // Verify that the renewal status and amount are updated correctly
        Assert.assertEquals(Status.PENDING, renewal.getRenewalStatus());
        Assert.assertEquals(100.0, renewal.getAmount(), 0.01);
    }

    /**
     * Tests the `clearView` method to ensure that the view reference is properly cleared.
     * Verifies that the view is set to null after calling the method.
     */
    @Test
    public void testClearView() {
        // Ensure the view is set initially
        Assert.assertNotNull(presenter.getView());

        // Call the clearView method
        presenter.clearView();

        // Verify that the view is set to null
        Assert.assertNull(presenter.getView());
    }
}