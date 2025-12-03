package com.example.parkingspotmanager.view.Customer.QRCode;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.domain.Customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `QRCodePresenterTest` class contains unit tests for the `QRCodePresenter` class.
 * It tests the functionality of creating QR codes, retrieving customer information, and clearing the view.
 */
public class QRCodePresenterTest {

    private QRCodePresenter presenter;
    private QRCodeViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new QRCodeViewStub();
        presenter = new QRCodePresenter();
        presenter.setView(view);
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /**
     * Tests the creation of a QR code for a given customer.
     * Verifies that the QR code creation process is successful and that the view's `onBitmap` method is called.
     */
    @Test
    public void testCreateQRCode() {
        Customer customer = new Customer("UsernameTest", "PasswordTest", "FirstName", "LastName", "email@example.com", "phoneNumber", new Vehicle("ΥΤΗ8584", "Toyota", "Yaris"));
        CustomerDAOMemory customerDAO = new CustomerDAOMemory();
        customerDAO.save(customer);
        presenter.createQRCode(customer, "UsernameTest");
        Assert.assertTrue(view.onBitmap);
    }

    /**
     * Tests the retrieval of customer information by username.
     * Verifies that the correct customer is retrieved and that the username matches.
     */
    @Test
    public void testFindCustomerInfo() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        Customer result = presenter.findCustomerInfo("UsernameTest");
        Assert.assertNotNull(result);
        Assert.assertEquals("UsernameTest", result.getUsername());
    }

    /**
     * Tests the retrieval of the currently logged-in customer.
     * Verifies that the correct customer is returned and that the username matches.
     */
    @Test
    public void testGetCustomer() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        presenter.findCustomerInfo("UsernameTest");
        Assert.assertNotNull(presenter.getCustomer());
        Assert.assertEquals("UsernameTest", presenter.getCustomer().getUsername());
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