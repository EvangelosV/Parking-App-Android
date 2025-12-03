package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.EmployeeDAO;
import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Employee;
import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class EmployeeDAOMemory implements EmployeeDAO {
    protected static ArrayList<Employee> entities = new ArrayList<Employee>();

    /**
     * Deletes all Employee entities from the in-memory list.
     */
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Saves an Employee entity to the in-memory list.
     *
     * @param entity The Employee object to be saved.
     */
    @Override
    public void save(Employee entity) {
        entities.add(entity);
    }

    /**
     * Finds an Employee by their username.
     *
     * @param employeeUsername The username of the Employee to find.
     * @return The Employee object if found, otherwise null.
     */
    @Override
    public Employee find(String employeeUsername) {
        for (Employee employee : entities) {
            if (employee.getUsername().equals(employeeUsername)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Deletes an Employee entity from the in-memory list.
     *
     * @param entity The Employee object to be deleted.
     */
    @Override
    public void delete(Employee entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all Employee entities stored in memory.
     *
     * @return An ArrayList containing all Employee objects.
     */
    @Override
    public ArrayList<Employee> findAll() {
        return new ArrayList<Employee>(entities);
    }

    /**
     * Finds an Employee by their credentials (username and password).
     *
     * @param credentials The credentials (username and password) to search for.
     * @return The Employee object if found, otherwise null.
     */
    @Override
    public Employee findByCredentials(Credentials credentials) {
        for (Employee employee : entities) {
            if (employee.getUsername().equals(credentials.getUsername()) &&
                    employee.getPassword().equals(credentials.getPassword())) {
                return employee;
            }
        }
        return null;
    }
}
