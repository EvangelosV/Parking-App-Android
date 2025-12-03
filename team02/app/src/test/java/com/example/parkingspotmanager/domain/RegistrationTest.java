package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest {

    private Customer customer;
    private Registration registration;

    @Before
    public void setUp() {
        customer = new Customer("Nikos","Nikolaidis","maou@maou.gr","12345678","Nikolakis", "1234567890", new Vehicle("ABC123", "Toyota", "Camry"));
        registration = new Registration(customer);
    }

    @Test
    public void testGetUser() {
        Assert.assertEquals(customer, registration.getCustomer());
    }

    @Test
    public void testSetUser() {
        //Customer newCustomer = new Customer("Kyriakos", "Grizzly", "Mitropoleos 12", "12345678", "maou@maou.gr");
        Customer newCustomer = new Customer("Kyriakos", "Grizzly", "maou@maou.gr", "12345678", "Katsaou", "1234567890", new Vehicle("ABC123", "Toyota", "Camry"));
        registration.setCustomer(newCustomer);
        Assert.assertEquals(newCustomer, registration.getCustomer());
    }

    @Test
    public void testDefaultStatus() {
        // Ensure the default status is PENDING
        Assert.assertEquals(Status.PENDING, registration.getStatus());
    }

    @Test
    public void testSetStatus() {
        registration.setStatus(Status.APPROVED);
        Assert.assertEquals(Status.APPROVED, registration.getStatus());
    }

    @Test
    public void testToString() {
        String expectedString = "Registration{username='Nikolakis', email='maou@maou.gr', status=PENDING}";
        Assert.assertEquals(expectedString, registration.toString());
    }
}
