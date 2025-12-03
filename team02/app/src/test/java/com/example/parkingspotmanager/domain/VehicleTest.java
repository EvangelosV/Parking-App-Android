package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

    Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle("1234ABC", "Toyota", "Corolla");
    }

    @Test
    public void testGetLicensePlate() {
        Assert.assertEquals("1234ABC", vehicle.getLicensePlate());
    }

    @Test
    public void testGetBrand() {
        Assert.assertEquals("Toyota", vehicle.getBrand());
    }

    @Test
    public void testGetModel() {
        Assert.assertEquals("Corolla", vehicle.getModel());
    }

    @Test
    public void testSetLicensePlate() {
        vehicle.setLicensePlate("1234DEF");
        Assert.assertEquals("1234DEF", vehicle.getLicensePlate());
    }

    @Test
    public void testSetBrand() {
        vehicle.setBrand("Honda");
        Assert.assertEquals("Honda", vehicle.getBrand());
    }

    @Test
    public void testSetModel() {
        vehicle.setModel("Civic");
        Assert.assertEquals("Civic", vehicle.getModel());
    }
}
