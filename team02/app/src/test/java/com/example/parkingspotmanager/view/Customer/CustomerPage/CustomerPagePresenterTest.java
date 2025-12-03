package com.example.parkingspotmanager.view.Customer.CustomerPage;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.domain.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `CustomerPagePresenterTest` class contains unit tests for the `CustomerPagePresenter` class.
 * It tests the functionality of retrieving customer information, handling user actions, and clearing the view.
 */
public class CustomerPagePresenterTest {

    private CustomerPagePresenter presenter;
    private CustomerPageViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new CustomerPageViewStub();
        presenter = new CustomerPagePresenter();
        presenter.setView(view);
        presenter.setCustomerDAO(new CustomerDAOMemory());
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

        String username = presenter.getCustomerUsername();
        Assert.assertEquals("UsernameTest", username);
    }

    /**
     * Tests the handling of user actions such as renewal, logout, search parking space, and showing QR code.
     * Verifies that the corresponding view methods are called.
     */
    @Test
    public void testActions() {
        presenter.onRenewal();
        Assert.assertTrue(view.onRenewal);

        presenter.onLogout();
        Assert.assertTrue(view.onLogout);

        presenter.onSearchParkingSpace();
        Assert.assertTrue(view.onSearchParkingSpace);

        presenter.onShowQRCode();
        Assert.assertTrue(view.onShowQRCode);
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