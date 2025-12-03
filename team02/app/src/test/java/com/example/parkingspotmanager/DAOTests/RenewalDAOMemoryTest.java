package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Renewal;
import com.example.parkingspotmanager.memorydao.RenewalDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RenewalDAOMemoryTest {

    private RenewalDAOMemory renewalDAOMemory;
    private Renewal renewal;
    private Customer customer;

    @Before
    public void setUp() {
        renewalDAOMemory = new RenewalDAOMemory();
        renewalDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        renewal = new Renewal(customer,20.0);
        renewalDAOMemory.save(renewal);
    }

    @Test
    public void testFindAll() {
        ArrayList<Renewal> renewals = renewalDAOMemory.findAll();
        Assert.assertEquals(1, renewals.size());
    }

    @Test
    public void testSave() {
        customer = new Customer("John", "Paris", "john.doe@company.com", "1234567890", "john_paris", "password123", null);
        Renewal newRenewal = new Renewal(customer,40.0);
        renewalDAOMemory.save(newRenewal);
        Assert.assertEquals(2, renewalDAOMemory.findAll().size());
    }

    @Test
    public void testDeleteAll() {
        renewalDAOMemory.deleteAll();
        Assert.assertTrue(renewalDAOMemory.findAll().isEmpty());
    }

}