package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Employee;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EmployeeDAOMemoryTest {

    private EmployeeDAOMemory employeeDAOMemory;
    private Employee employee;

    @Before
    public void setUp() {
        employeeDAOMemory = new EmployeeDAOMemory();
        employeeDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        employee = new Employee("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123");
        employeeDAOMemory.save(employee);
    }

    @Test
    public void testFindAll() {
        ArrayList<Employee> employees = employeeDAOMemory.findAll();
        Assert.assertEquals(1, employees.size());
    }

    @Test
    public void testSave() {
        Employee newEmployee = new Employee("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456");
        employeeDAOMemory.save(newEmployee);
        Assert.assertEquals(2, employeeDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        Employee foundEmployee = employeeDAOMemory.find("john_doe");
        Assert.assertNotNull(foundEmployee);
        Assert.assertEquals("john_doe", foundEmployee.getUsername());
    }

    @Test
    public void testFindByCredentials() {
        Credentials credentials = new Credentials("john_doe", "password123");
        Employee foundEmployee = employeeDAOMemory.findByCredentials(credentials);
        Assert.assertNotNull(foundEmployee);
        Assert.assertEquals("john_doe", foundEmployee.getUsername());
    }

    @Test
    public void testDelete() {
        employeeDAOMemory.delete(employee);
        Assert.assertNull(employeeDAOMemory.find("john_doe"));
    }

    @Test
    public void testDeleteAll() {
        employeeDAOMemory.deleteAll();
        Assert.assertTrue(employeeDAOMemory.findAll().isEmpty());
    }

}