package com.example.parkingspotmanager.view.User.Login;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `LoginPresenterTest` class contains unit tests for the `LoginPresenter` class.
 * It tests the functionality of validating user credentials, handling login success and failure,
 * and clearing the view.
 */
public class LoginPresenterTest {

    private LoginPresenter presenter;
    private LoginViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter,
     * and sets up the DAOs for customers, employees, and management.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new LoginViewStub();
        presenter = new LoginPresenter();
        presenter.setView(view);
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setManagementDAO(new ManagementDAOMemory());
        presenter.setEmployeeDAO(new EmployeeDAOMemory());
    }

    /**
     * Tests a successful login scenario.
     * Verifies that the correct user is retrieved after validating credentials.
     */
    @Test
    public void loginSuccess() {
        presenter.validateCredentials();
        Assert.assertEquals(presenter.getUser(), new CustomerDAOMemory().find("UsernameTest"));
    }

    /**
     * Tests a failed login scenario.
     * Verifies that no user is retrieved when invalid credentials are provided.
     */
    @Test
    public void loginFail() {
        new CustomerDAOMemory().delete(new CustomerDAOMemory().find("tommy0"));
        presenter.validateCredentials();
        Assert.assertNull(presenter.getUser());
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