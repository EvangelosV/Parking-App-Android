package com.example.parkingspotmanager.view.Employee.EmployeePage;

import com.example.parkingspotmanager.dao.EmployeeDAO;
import com.example.parkingspotmanager.domain.Employee;

/**
 * The EmployeePagePresenter class handles the business logic for the employee page.
 * It interacts with the EmployeePageView interface to update the UI and uses the EmployeeDAO
 * to manage employee data.
 */
public class EmployeePagePresenter {
    private EmployeePageView view;
    private EmployeeDAO employeeDAO;
    private Employee employee;

    /**
     * Default constructor for EmployeePagePresenter.
     */
    public EmployeePagePresenter() {
    }

    /**
     * Retrieves employee information based on the provided username.
     *
     * @param employeeUsername The username of the employee to find.
     */
    public void findEmployeeInfo(String employeeUsername) {
        if (employeeUsername == null)
            return;
        employee = employeeDAO.find(employeeUsername);
    }

    /**
     * Sets the EmployeeDAO instance to be used by the presenter.
     *
     * @param employeeDAO The EmployeeDAO instance.
     */
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**
     * Returns the username of the current employee.
     *
     * @return The username of the employee, or an empty string if no employee is set.
     */
    public String getEmployeeUsername() {
        if (employee == null)
            return "";
        return employee.getUsername();
    }

    /**
     * Handles the logout action.
     */
    public void onLogout() {
        view.toLogout();
    }

    /**
     * Handles the registrations action.
     */
    public void onRegistrations() {
        view.toRegistrations();
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Sets the view interface for this presenter.
     *
     * @param view The EmployeePageView interface implementation.
     */
    public void setView(EmployeePageView view) {
        this.view = view;
    }

    /**
     * Returns the EmployeeDAO instance used by the presenter.
     *
     * @return The EmployeeDAO instance.
     */
    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    /**
     * Returns the current employee object.
     *
     * @return The Employee object.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Returns the current view interface.
     *
     * @return The EmployeePageView interface implementation.
     */
    public Object getView() {
        return view;
    }
}