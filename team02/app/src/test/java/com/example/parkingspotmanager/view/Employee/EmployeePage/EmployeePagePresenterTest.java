package com.example.parkingspotmanager.view.Employee.EmployeePage;

import com.example.parkingspotmanager.domain.Employee;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `EmployeePagePresenterTest` class contains unit tests for the `EmployeePagePresenter` class.
 * It tests the functionality of retrieving employee information, handling logout and registrations actions,
 * and clearing the view.
 */
public class EmployeePagePresenterTest {

    private EmployeePagePresenter presenter;
    private EmployeePageViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the view and presenter,
     * and sets up the `EmployeeDAO`.
     */
    @Before
    public void setUp() {
        view = new EmployeePageViewStub();
        presenter = new EmployeePagePresenter();
        presenter.setView(view);
        presenter.setEmployeeDAO(new EmployeeDAOMemory());
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
     * Tests the logout action.
     * Verifies that the `onLogout` method is called and the corresponding view method is triggered.
     */
    @Test
    public void testOnLogout() {
        presenter.onLogout();
        Assert.assertTrue(view.toLogoutCalled);
    }

    /**
     * Tests the navigation to the registrations page.
     * Verifies that the `onRegistrations` method is called and the corresponding view method is triggered.
     */
    @Test
    public void testOnRegistrations() {
        presenter.onRegistrations();
        Assert.assertTrue(view.toRegistrationsCalled);
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
}