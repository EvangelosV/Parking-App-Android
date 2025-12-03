package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("Maou","Katsaou","maou@maou.gr", "1234567890", "KYRIAKOS", "1234ABCD");
    }

    @Test
    public void testApproveRequest() {
        Vehicle vehicle = new Vehicle("1234ABC", "Toyota", "Corolla");
        Customer customer = new Customer("Rawr","Doe","Rawr@doe.gr", "1234567890", "KYRIAKOS", "1234ABCD", vehicle);
        Registration registration= new Registration(customer);

        employee.approveRegistration(registration);
    }

    @Test
    public void testRejectRequest() {
        Vehicle vehicle = new Vehicle("1234ABC", "Toyota", "Corolla");
        Customer customer = new Customer("Rawr","Doe","Rawr@doe.gr", "1234567890", "KYRIAKOS", "1234ABCD", vehicle);
        Registration registration = new Registration(customer);

        employee.rejectRegistration(registration);
        Assert.assertEquals(Status.REJECTED, registration.getStatus());
    }
}
