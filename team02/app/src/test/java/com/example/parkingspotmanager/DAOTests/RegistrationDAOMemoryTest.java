package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.domain.Status;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RegistrationDAOMemoryTest {

    private RegistrationDAOMemory registrationDAOMemory;
    private Registration registration;
    private Customer customer;
    private Registration registrationPending;
    private Customer customerPending;
    private Registration registrationApproved;
    private Customer customerApproved;

    @Before
    public void setUp() {
        registrationDAOMemory = new RegistrationDAOMemory();
        registrationDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        registration = new Registration(customer);
        registration.setStatus(Status.APPROVED);
        registrationDAOMemory.save(registration);
        customerPending = new Customer("John", "Kappa", "john.doe@company.com", "1234567890", "john_kappa", "password123", null);
        registrationPending = new Registration(customerPending);
        registrationPending.setStatus(Status.PENDING);

        customerApproved = new Customer("Jane", "Momo", "jane.doe@company.com", "0987654321", "jane_momo", "password456", null);
        registrationApproved = new Registration(customerApproved);
        registrationApproved.setStatus(Status.APPROVED);

        registrationDAOMemory.save(registrationPending);
        registrationDAOMemory.save(registrationApproved);
    }

    @Test
    public void testFindAll() {
        ArrayList<Registration> registrations = (ArrayList<Registration>) registrationDAOMemory.findAll();
        Assert.assertEquals(3, registrations.size());
    }

    @Test
    public void testSave() {
        customer = new Customer("John", "Paris", "john.doe@company.com", "1234567890", "john_paris", "password123", null);
        Registration newRegistration = new Registration(customer);
        registrationDAOMemory.save(newRegistration);
        Assert.assertEquals(4, registrationDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        Registration foundRegistration = registrationDAOMemory.findByUsername(registration.getCustomer().getUsername());
        Assert.assertNotNull(foundRegistration);
        Assert.assertEquals(registration.getCustomer().getUsername(), foundRegistration.getCustomer().getUsername());
    }

    @Test
    public void testDelete() {
        registrationDAOMemory.delete(registration);
        Assert.assertNull(registrationDAOMemory.findByUsername(registration.getCustomer().getUsername()));
    }

    @Test
    public void testDeleteAll() {
        registrationDAOMemory.deleteAll();
        Assert.assertTrue(registrationDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testFindAllPending() {
        ArrayList<Registration> pendingRegistrations = registrationDAOMemory.findAllPending();
        Assert.assertEquals(1, pendingRegistrations.size());
        Assert.assertEquals(Status.PENDING, pendingRegistrations.get(0).getStatus());
    }

    @Test
    public void testFindAllApproved() {
        ArrayList<Registration> approvedRegistrations = registrationDAOMemory.findAllApproved();
        Assert.assertEquals(2, approvedRegistrations.size());
        Assert.assertEquals(Status.APPROVED, approvedRegistrations.get(0).getStatus());
    }


}