package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Management;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ManagementDAOMemoryTest {

    private ManagementDAOMemory managementDAOMemory;
    private Management management;

    @Before
    public void setUp() {
        managementDAOMemory = new ManagementDAOMemory();
        managementDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        management = new Management("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123");
        managementDAOMemory.save(management);
    }

    @Test
    public void testFindAll() {
        ArrayList<Management> managements = managementDAOMemory.findAll();
        Assert.assertEquals(1, managements.size());
    }

    @Test
    public void testSave() {
        Management newManagement = new Management("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456");
        managementDAOMemory.save(newManagement);
        Assert.assertEquals(2, managementDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        Management foundManagement = managementDAOMemory.find("john_doe");
        Assert.assertNotNull(foundManagement);
        Assert.assertEquals("john_doe", foundManagement.getUsername());
    }

    @Test
    public void testFindByCredentials() {
        Credentials credentials = new Credentials("john_doe", "password123");
        Management foundManagement = managementDAOMemory.findByCredentials(credentials);
        Assert.assertNotNull(foundManagement);
        Assert.assertEquals("john_doe", foundManagement.getUsername());
    }

    @Test
    public void testDelete() {
        managementDAOMemory.delete(management);
        Assert.assertNull(managementDAOMemory.find("john_doe"));
    }

    @Test
    public void testDeleteAll() {
        managementDAOMemory.deleteAll();
        Assert.assertTrue(managementDAOMemory.findAll().isEmpty());
    }
}