package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer customer;
    private Vehicle vehicle;

    @Before
    public void setUp() {
        Vehicle vehicle = new Vehicle("1234ABC", "Toyota", "Corolla");
        customer = new Customer("John","Doe","maou@maou.gr", "1234567890", "KYRIAKOS", "1234ABCD", vehicle);
    }

    @Test
    public void testConstructorA() {
        Customer customer = new Customer("John","Doe","maou@maou.gr", "1234567890", "KYRIAKOS", "12345678", vehicle);
        Assert.assertEquals(customer.getVehicle(), vehicle);
        Assert.assertEquals(customer.getEmail(), "maou@maou.gr");
        Assert.assertEquals(customer.getPhoneNumber(), "1234567890");
        Assert.assertEquals(customer.getUsername(), "KYRIAKOS");
        Assert.assertEquals(customer.getPassword(), "12345678");
    }

    @Test
    public void testSetAndGetVehicle() {
        Vehicle vehicle = new Vehicle("1234ABC", "Toyota", "Corolla");
        customer.setVehicle(vehicle);
        Assert.assertEquals(vehicle, customer.getVehicle());
    }

    @Test
    public void testSetAndGetAccountBalance() {
        customer.setAccountBalance(100.50);
        Assert.assertEquals(100.50, customer.getAccountBalance(), 0.0);
    }
}

