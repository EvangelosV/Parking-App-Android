package com.example.parkingspotmanager.DAOTests;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;
import com.example.parkingspotmanager.memorydao.VehicleDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemoryInitializerTest {

    private MemoryInitializer memoryInitializer;

    @Before
    public void setUp() {
        memoryInitializer = new MemoryInitializer();
        memoryInitializer.prepareData();
    }

    @Test
    public void testInitializeCustomers() {
        CustomerDAOMemory customerDAOMemory = new CustomerDAOMemory();
        Assert.assertFalse(customerDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testInitializeEmployees() {
        EmployeeDAOMemory employeeDAOMemory = new EmployeeDAOMemory();
        Assert.assertFalse(employeeDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testInitializeManagements() {
        ManagementDAOMemory managementDAOMemory = new ManagementDAOMemory();
        Assert.assertFalse(managementDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testInitializeRegistrations() {
        RegistrationDAOMemory registrationDAOMemory = new RegistrationDAOMemory();
        Assert.assertFalse(registrationDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testInitializeVehicles() {
        VehicleDAOMemory vehicleDAOMemory = new VehicleDAOMemory();
        Assert.assertFalse(vehicleDAOMemory.findAll().isEmpty());
    }
}