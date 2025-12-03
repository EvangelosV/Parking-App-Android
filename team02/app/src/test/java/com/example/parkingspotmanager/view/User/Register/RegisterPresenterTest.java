package com.example.parkingspotmanager.view.User.Register;

import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `RegisterPresenterTest` class contains unit tests for the `RegisterPresenter` class.
 * It tests the functionality of creating new registrations and clearing the view.
 */
public class RegisterPresenterTest {

    private RegisterPresenter presenter;
    private RegisterView view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter,
     * and sets up the DAOs for customers and registrations.
     *
     * @throws Exception if the setup fails.
     */
    @Before
    public void setup() {
        new MemoryInitializer().prepareData();
        view = new RegisterViewStub();
        presenter = new RegisterPresenter();
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setRegistrationDAO(new RegistrationDAOMemory());
        presenter.setView(view);
    }

    /**
     * Tests the creation of a new registration.
     * Verifies that a new registration is successfully created and saved in the `RegistrationDAO`.
     */
    @Test
    public void createNew() {
        // Set up the registration data in the view
        view.setUsername("AndreasTesting");
        view.setPassword("Password123");
        view.setFirstName("Adnreas");
        view.setLastName("Tester");
        view.setPhoneNumber("0000000000");
        view.setEmail("aaaa@aaaa");
        view.setLicensePlate("AAA1234");
        view.setBrand("Toyota");
        view.setModel("Yaris");

        // Get the initial number of registrations
        int registrations1 = new RegistrationDAOMemory().findAll().size();

        // Handle the customer data (create a new registration)
        presenter.handleCustomerData();

        // Get the updated number of registrations
        int registrations2 = new RegistrationDAOMemory().findAll().size();

        // Verify that the number of registrations has increased by 1
        Assert.assertEquals(registrations1 + 1, registrations2);

        // Verify that the created registration matches the one saved in the DAO
        Assert.assertEquals(presenter.getRegistration(), new RegistrationDAOMemory().findByUsername("AndreasTesting"));
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