package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.VehicleDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class VehicleDAOMemoryTest {

    private VehicleDAOMemory vehicleDAOMemory;
    private Vehicle vehicle;
    private Customer customer;

    @Before
    public void setUp() {
        vehicleDAOMemory = new VehicleDAOMemory();
        vehicleDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", vehicle);
        vehicle = new Vehicle("ABC1234", "Toyota", "Corolla");
        vehicleDAOMemory.save(vehicle);
    }


    @Test
    public void testFindAll() {
        List<Vehicle> vehicles = vehicleDAOMemory.findAll();
        Assert.assertEquals(1, vehicles.size());
    }

    @Test
    public void testSave() {
        Customer newCustomer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        Vehicle newVehicle = new Vehicle("XYZ7893", "Honda", "Civic");
        vehicleDAOMemory.save(newVehicle);
        Assert.assertEquals(2, vehicleDAOMemory.findAll().size());
    }



    @Test
    public void testDeleteAll() {
        vehicleDAOMemory.deleteAll();
        Assert.assertTrue(vehicleDAOMemory.findAll().isEmpty());
    }
}