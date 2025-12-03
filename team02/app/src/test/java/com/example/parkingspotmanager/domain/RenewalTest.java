package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RenewalTest {

    private Renewal renewal;
    private Customer customer;
    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;
    private ParkingTicket parkingTicket;
    private Reservation reservation;
    LocalTime endDateTime = LocalTime.of(20, 0);
    LocalTime entryDateTime = LocalTime.of(10, 0);
    LocalTime reservedExitDateTime = LocalTime.of(18, 0);

    @Before
    public void setUp() {
        customer = new Customer("Giorgos", "Georgiou", "Mitropoleos 12", "12345678", "Giorgakis","12345678", new Vehicle("ABC123", "Toyota", "Camry"));
        renewal = new Renewal(customer, 100.0);
        parkingBuilding = new ParkingBuilding(1, "123 Main St, City",
                "08:00", "20:00", "12345");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false,
                false, 5.00);
        parkingTicket = new ParkingTicket(1234, parkingSpace, parkingBuilding,
                entryDateTime, endDateTime, 5.00);
        reservation = new Reservation(parkingSpace, customer,
                entryDateTime, reservedExitDateTime, 5.00);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(customer, renewal.getCustomer());
        Assert.assertEquals(100.0, renewal.getAmount(), 0.001);
        Assert.assertNotNull(renewal.getRenewalDate());
        Assert.assertEquals(Status.PENDING, renewal.getRenewalStatus());
    }

    @Test
    public void testSetCustomer() {
        Customer newCustomer = new Customer("Giorgos", "Georgiou", "Mitropoleos 12", "12345678", "Giorgakis","12345678", new Vehicle("ABC123", "Toyota", "Camry"));
        renewal.setCustomer(newCustomer);
        Assert.assertEquals(newCustomer, renewal.getCustomer());
    }

    @Test
    public void testSetAmount() {
        renewal.setAmount(200.0);
        Assert.assertEquals(200.0, renewal.getAmount(), 0.001);
    }

    @Test
    public void testSetRenewalDate() {
        LocalDateTime newDate = LocalDateTime.of(2024, 12, 5, 10, 30);
        renewal.setRenewalDate(newDate);
        Assert.assertEquals(newDate, renewal.getRenewalDate());
    }

    @Test
    public void testSetRenewalStatus() {
        renewal.setRenewalStatus(Status.APPROVED);
        Assert.assertEquals(Status.APPROVED, renewal.getRenewalStatus());
    }

    @Test
    public void testSetAndGetPayment() {
        Payment payment = new Payment(customer, reservation, 20.0, 1);
        renewal.setPayment(payment);
        Assert.assertEquals(payment, renewal.getPayment());
    }

    @Test
    public void testProcessRenewalSuccess() {
        renewal.setRenewalStatus(Status.PENDING);
        renewal.setPayment(new Payment(customer, reservation, 20.0, 2));
        renewal.getPayment().setPaymentStatus(Status.APPROVED);
        renewal.setAmount(50.0);
        renewal.getCustomer().setAccountBalance(100.0);
        renewal.processRenewal();
        Assert.assertEquals(Status.APPROVED, renewal.getRenewalStatus());
        Assert.assertEquals(150.0, customer.getAccountBalance(), 0.001);
    }

    @Test
    public void testProcessRenewalFailPayment() {
        renewal.setRenewalStatus(Status.PENDING);
        renewal.setPayment(new Payment(customer, reservation, 20.0, 3));
        renewal.getPayment().setPaymentStatus(Status.REJECTED);
        renewal.setAmount(50.0);
        renewal.getCustomer().setAccountBalance(100.0);
        renewal.processRenewal();
        Assert.assertEquals(Status.REJECTED, renewal.getRenewalStatus());
        Assert.assertEquals(100.0, customer.getAccountBalance(), 0.001);
    }

    @Test
    public void testProcessRenewalNoPayment() {
        renewal.setRenewalStatus(Status.PENDING);
        renewal.setPayment(null);
        renewal.setAmount(50.0);
        renewal.getCustomer().setAccountBalance(100.0);
        renewal.processRenewal();
        Assert.assertEquals(Status.APPROVED, renewal.getRenewalStatus());
        Assert.assertEquals(150.0, customer.getAccountBalance(), 0.001);
    }


}
