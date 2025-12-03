package com.example.parkingspotmanager.view.Employee.EmployeePage;

/**
 * The EmployeePageView interface defines the contract for the view that handles the employee page.
 * It provides methods for navigating to the registrations page and logging out.
 */
public interface EmployeePageView {

    /**
     * Navigates to the registrations page.
     */
    void toRegistrations();

    /**
     * Logs out the employee and navigates back to the home page.
     */
    void toLogout();
}