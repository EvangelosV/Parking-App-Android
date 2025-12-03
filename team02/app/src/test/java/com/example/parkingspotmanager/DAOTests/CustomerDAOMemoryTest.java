package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomerDAOMemoryTest {

    private CustomerDAOMemory customerDAOMemory;
    private Customer customer;

    @Before
    public void setUp() {
        customerDAOMemory = new CustomerDAOMemory();
        customerDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        customerDAOMemory.save(customer);
    }

    @Test
    public void testFindAll() {
        ArrayList<Customer> customers = customerDAOMemory.findAll();
        Assert.assertEquals(1, customers.size());
    }

    @Test
    public void testSave() {
        Customer newCustomer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        customerDAOMemory.save(newCustomer);
        Assert.assertEquals(2, customerDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        Customer foundCustomer = customerDAOMemory.find("john_doe");
        Assert.assertNotNull(foundCustomer);
        Assert.assertEquals("john_doe", foundCustomer.getUsername());
    }

    @Test
    public void testFindByCredentials() {
        Credentials credentials = new Credentials("john_doe", "password123");
        Customer foundCustomer = customerDAOMemory.findByCredentials(credentials);
        Assert.assertNotNull(foundCustomer);
        Assert.assertEquals("john_doe", foundCustomer.getUsername());
    }

    @Test
    public void testDelete() {
        customerDAOMemory.delete(customer);
        Assert.assertNull(customerDAOMemory.find("john_doe"));
    }

    @Test
    public void testDeleteAll() {
        customerDAOMemory.deleteAll();
        Assert.assertTrue(customerDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testFindByEmail() {
        Customer foundCustomer = customerDAOMemory.findByEmail("john.doe@company.com");
        Assert.assertNotNull(foundCustomer);
        Assert.assertEquals("john.doe@company.com", foundCustomer.getEmail());
    }

    @Test
    public void testFindByPhone() {
        Customer foundCustomer = customerDAOMemory.findByPhone("1234567890");
        Assert.assertNotNull(foundCustomer);
        Assert.assertEquals("1234567890", foundCustomer.getPhoneNumber());
    }
}