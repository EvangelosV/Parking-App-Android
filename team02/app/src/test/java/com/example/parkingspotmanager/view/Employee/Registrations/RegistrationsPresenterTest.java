package com.example.parkingspotmanager.view.Employee.Registrations;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Employee;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `RegistrationsPresenterTest` class contains unit tests for the `RegistrationsPresenter` class.
 * It tests the functionality of retrieving employee information, handling registration approvals and rejections,
 * fetching registrations, navigating to the home page, and clearing the view.
 */
public class RegistrationsPresenterTest {

    private RegistrationsPresenter presenter;
    private RegistrationsViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the view and presenter,
     * and sets up the `EmployeeDAO` and `RegistrationDAO`.
     */
    @Before
    public void setUp() {
        view = new RegistrationsViewStub();
        presenter = new RegistrationsPresenter();
        presenter.setView(view);
        presenter.setEmployeeDAO(new EmployeeDAOMemory()); // Initialize EmployeeDAO
        presenter.setRegistrationDAO(new RegistrationDAOMemory());
    }

    /**
     * Tests the retrieval of employee information by username.
     * Verifies that the correct employee is retrieved and that the username matches.
     */
    @Test
    public void testFindEmployeeInfo() {
        Employee employee = new Employee("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123");
        presenter.getEmployeeDAO().save(employee);

        presenter.findEmployeeInfo("john_doe");
        Assert.assertNotNull(presenter.getEmployee());
        Assert.assertEquals("john_doe", presenter.getEmployee().getUsername());
    }

    /**
     * Tests the `clearView` method to ensure that the view reference is properly cleared.
     * Verifies that the view is set to null after calling the method.
     */
    @Test
    public void testClearView() {
        Assert.assertNotNull(presenter.getView());
        presenter.clearView();
        Assert.assertNull(presenter.getView());
    }

    /**
     * Tests the approval of a registration.
     * Verifies that the registration is marked as approved and that it exists in the `RegistrationDAO`.
     */
    @Test
    public void testAcceptRegistration() {
        Employee employee = new Employee("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123");
        presenter.getEmployeeDAO().save(employee);
        presenter.findEmployeeInfo("john_doe");

        Registration reg = new Registration(new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla")));
        presenter.getRegistrationDAO().save(reg);

        presenter.acceptRegistration(reg);

        Assert.assertTrue(reg.isApproved());
        Assert.assertNotNull(presenter.getRegistrationDAO().findByUsername(reg.getCustomer().getUsername()));
    }

    /**
     * Tests the rejection of a registration.
     * Verifies that the registration is marked as rejected and that it exists in the `RegistrationDAO`.
     */
    @Test
    public void testRejectRegistration() {
        Employee employee = new Employee("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123");
        presenter.getEmployeeDAO().save(employee);
        presenter.findEmployeeInfo("john_doe");

        Registration reg = new Registration(new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla")));
        presenter.getRegistrationDAO().save(reg);

        presenter.declineRegistration(reg);

        Assert.assertTrue(reg.isRejected());
        Assert.assertNotNull(presenter.getRegistrationDAO().findByUsername(reg.getCustomer().getUsername()));
    }

    /**
     * Tests the retrieval of all registrations.
     * Verifies that the list of registrations is not null.
     */
    @Test
    public void testGetRegistrations() {
        Registration reg = new Registration(new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla")));
        presenter.getRegistrationDAO().save(reg);
        Assert.assertNotNull(presenter.getRegistrations());
    }

    /**
     * Tests the navigation to the home page.
     * Verifies that the `onHomePage` method is called and the corresponding view method is triggered.
     */
    @Test
    public void testOnHomePage() {
        presenter.onHomePage();
        Assert.assertTrue(((RegistrationsViewStub) view).onHomePage);
    }
}