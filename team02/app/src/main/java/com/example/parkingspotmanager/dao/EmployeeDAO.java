package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Employee;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface EmployeeDAO {

    /**
     * Save an employee
     * @param entity the employee to be saved
     */
    void save(Employee entity);

    /**
     * Find an employee by username
     * @param employeeUsername the username of the employee
     */
    Employee find(String employeeUsername);

    /**
     * Delete an employee
     * @param entity the employee to be deleted
     */
    void delete(Employee entity);

    /**
     * Find all employees
     */
    ArrayList<Employee> findAll();

    /**
     * Find an employee by credentials
     * @param credentials the email of the employee
     */
    Employee findByCredentials(Credentials credentials);

    /**
     * Delete all employees
     */
    void deleteAll();
}
