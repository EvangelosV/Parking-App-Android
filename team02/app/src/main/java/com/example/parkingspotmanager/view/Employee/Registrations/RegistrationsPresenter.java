package com.example.parkingspotmanager.view.Employee.Registrations;

import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Employee;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.dao.EmployeeDAO;
import com.example.parkingspotmanager.dao.RegistrationDAO;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;

import java.util.ArrayList;

/**
 * The RegistrationsPresenter class handles the business logic for managing customer registrations.
 * It interacts with the RegistrationsView interface to update the UI and uses the EmployeeDAO,
 * RegistrationDAO, and CustomerDAO to manage employee, registration, and customer data.
 */
public class RegistrationsPresenter {
    private RegistrationsView view;
    private Employee employee;
    private EmployeeDAO employeeDAO;
    private CustomerDAO customerDAO;
    private RegistrationDAO registrationDAO;

    /**
     * Default constructor for RegistrationsPresenter.
     */
    public RegistrationsPresenter() {
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
     * Sets the view interface for this presenter.
     *
     * @param view The RegistrationsView interface implementation.
     */
    public void setView(RegistrationsView view) {
        this.view = view;
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
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
     * Sets the RegistrationDAO instance to be used by the presenter.
     *
     * @param registrationDAO The RegistrationDAO instance.
     */
    public void setRegistrationDAO(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    /**
     * Returns the list of pending registrations.
     *
     * @return An ArrayList containing all pending Registration objects.
     */
    public ArrayList<Registration> getRegistrations() {
        return registrationDAO.findAllPending();
    }

    /**
     * Declines a registration by rejecting it.
     *
     * @param registration The registration to decline.
     */
    public void declineRegistration(Registration registration) {
        employee.rejectRegistration(registration);
    }

    /**
     * Accepts a registration by approving it and saving the customer.
     *
     * @param registration The registration to accept.
     */
    public void acceptRegistration(Registration registration) {
        employee.approveRegistration(registration);
        Customer customer = registration.getCustomer();
        customerDAO = new CustomerDAOMemory();
        customerDAO.save(customer);
    }

    /**
     * what happens when the homepage button is pressed
     */
    public void onHomePage() {
        view.backToHomePage();
    }

    /**
     * Returns the current view interface.
     *
     * @return The RegistrationsView interface implementation.
     */
    public Object getView() {
        return view;
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
     * Returns the RegistrationDAO instance used by the presenter.
     *
     * @return The RegistrationDAO instance.
     */
    public RegistrationDAO getRegistrationDAO() {
        return registrationDAO;
    }
}