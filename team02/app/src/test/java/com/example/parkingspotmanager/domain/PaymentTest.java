package com.example.parkingspotmanager.domain;

import com.example.parkingspotmanager.util.ParkingExceptions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PaymentTest {

    private Customer customer;
    private Reservation reservation;
    private ParkingTicket parkingTicket;
    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;
    private ReservationTicket reservationTicket;
    private double amount;
    private Payment payment;
    LocalTime startDateTime = LocalTime.of(8, 0);
    LocalTime endDateTime = LocalTime.of(20, 0);
    LocalTime entryDateTime = LocalTime.of(10, 0);
    LocalTime reservedExitDateTime = LocalTime.of(218, 0);
    private final ByteArrayOutputStream outPrint = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outPrint));
        Vehicle custVehicle = new Vehicle("1234", "Toyota", "Yaris");
        customer = new Customer("Maou","Maou","maou@maou.gr", "12345679",
                "GRIZZLY", "1234ABCD", custVehicle);
        parkingBuilding = new ParkingBuilding(1, "123 Main St, City",
                "08:00", "20:00", "12345");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false,
                false, 5.00);
        parkingTicket = new ParkingTicket(1234, parkingSpace, parkingBuilding,
                entryDateTime, endDateTime, 5.00);
        reservation = new Reservation(parkingSpace, customer,
                entryDateTime, reservedExitDateTime, 5.00);
        reservationTicket = new ReservationTicket(reservation,  startDateTime, endDateTime, 5.00);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testConstructorA(){
        Payment payment = new Payment(customer, reservation, 5.00, 1);
        Assert.assertEquals(customer, payment.getCustomer());
        Assert.assertEquals(reservation, payment.getReservation());
        Assert.assertEquals(5.00, payment.getAmount(), 0.001);
    }

    @Test
    public void testConstructorB(){
        Payment payment = new Payment(customer, parkingTicket, 5.00, 2);
        Assert.assertEquals(customer, payment.getCustomer());
        Assert.assertEquals(parkingTicket, payment.getParkingTicket());
        Assert.assertEquals(5.00, payment.getAmount(), 0.001);
    }

    @Test
    public void testConstructorC(){
        Payment payment = new Payment(customer, reservationTicket, 5.00, 3);
        Assert.assertEquals(customer, payment.getCustomer());
        Assert.assertEquals(reservationTicket, payment.getReservationTicket());
        Assert.assertEquals(5.00, payment.getAmount(), 0.001);
    }

    @Test
    public void testProcessPayment(){
        customer.setAccountBalance(10.00);
        double startBalance = customer.getAccountBalance();
        Payment payment = new Payment(customer, reservation, 5.00, 4);
        payment.processPayment(customer);
        double endBalance = customer.getAccountBalance();
        Assert.assertEquals(Status.APPROVED, payment.getPaymentStatus());
        Assert.assertEquals(startBalance - endBalance, payment.getAmount(), 0.001);
    }


    @Test(expected = ParkingExceptions.class)
    public void testProcessPaymentInsufficientFunds() {

        customer.setAccountBalance(1.00);
        Payment payment = new Payment(customer, reservation, 5.00, 5);

        payment.processPayment(customer); // This should throw ParkingExceptions

    }

    @Test
    public void testUpdatePaymentStatusToPending() {
        Payment payment = new Payment(customer, reservation, 5.00, 6);
        payment.updatePaymentStatus(Status.PENDING);
        Assert.assertEquals(Status.PENDING, payment.getPaymentStatus());
    }

    @Test
    public void testUpdatePaymentStatusToApproved() {
        Payment payment = new Payment(customer, reservation, 5.00, 7);
        payment.updatePaymentStatus(Status.APPROVED);
        Assert.assertEquals(Status.APPROVED, payment.getPaymentStatus());
    }

    @Test
    public void testUpdatePaymentStatusToRejected() {
        Payment payment = new Payment(customer, reservation, 5.00, 8);
        payment.updatePaymentStatus(Status.REJECTED);
        Assert.assertEquals(Status.REJECTED, payment.getPaymentStatus());
    }

    @Test
    public void testSendPaymentConfirmation() {
        Payment payment = new Payment(customer, reservation, 5.00, 10);
        payment.updatePaymentStatus(Status.APPROVED);
        boolean result = payment.sendPaymentConfirmation();
        Assert.assertTrue(result);
        payment.updatePaymentStatus(Status.PENDING);
        result = payment.sendPaymentConfirmation();
        Assert.assertFalse(result);
        payment.updatePaymentStatus(Status.REJECTED);
        result = payment.sendPaymentConfirmation();
        Assert.assertFalse(result);
    }

    @Test
    public void testSetAmount() {
        Payment payment = new Payment(customer, reservation, 5.00, 18);
        payment.setAmount(10.00);
        Assert.assertEquals(10.00, payment.getAmount(), 0.001);
    }

    @Test
    public void testSetPaymentStatus() {
        Payment payment = new Payment(customer, reservation, 5.00,19);
        payment.setPaymentStatus(Status.APPROVED);
        Assert.assertEquals(Status.APPROVED, payment.getPaymentStatus());
    }

    @Test
    public void testSetPaymentDate() {
        Payment payment = new Payment(customer, reservation, 5.00, 20);
        payment.setPaymentDate(startDateTime);
        Assert.assertEquals(startDateTime, payment.getPaymentDate());
    }

    @Test
    public void testSetCustomer() {
        Payment payment = new Payment(customer, reservation, 5.00, 21);
        Vehicle newVehicle = new Vehicle("5678", "Toyota", "Yaris");
        Customer newCustomer = new Customer("Kyriakos", "Grizzly", "Mitropoleos 12", "12345678", "Kyriakos", "1234ABCD", newVehicle);
        payment.setCustomer(newCustomer);
        Assert.assertEquals(newCustomer, payment.getCustomer());
    }

    @Test
    public void testSetReservation() {
        Payment payment = new Payment(customer, reservation, 5.00, 22);
        Reservation newReservation = new Reservation(parkingSpace, customer,
                entryDateTime, reservedExitDateTime, 5.00);
        payment.setReservation(newReservation);
        Assert.assertEquals(newReservation, payment.getReservation());
    }

    @Test
    public void testSetParkingTicket() {
        Payment payment = new Payment(customer, parkingTicket, 5.00, 23);
        ParkingTicket newParkingTicket = new ParkingTicket(5678, parkingSpace, parkingBuilding,
                entryDateTime, endDateTime, 5.00);
        payment.setParkingTicket(newParkingTicket);
        Assert.assertEquals(newParkingTicket, payment.getParkingTicket());
    }

    @Test
    public void testSetReservationTicket() {
        Payment payment = new Payment(customer, reservationTicket, 5.00, 24);
        ReservationTicket newReservationTicket = new ReservationTicket(reservation, startDateTime, endDateTime, 5.00);
        payment.setReservationTicket(newReservationTicket);
        Assert.assertEquals(newReservationTicket, payment.getReservationTicket());
    }

    @Test
    public void getCustomer() {
        Payment payment = new Payment(customer, reservation, 5.00, 25);
        Assert.assertEquals(customer, payment.getCustomer());
    }

    @Test
    public void getReservation() {
        Payment payment = new Payment(customer, reservation, 5.00, 26);
        Assert.assertEquals(reservation, payment.getReservation());
    }

    @Test
    public void getParkingTicket() {
        Payment payment = new Payment(customer, parkingTicket, 5.00, 17);
        Assert.assertEquals(parkingTicket, payment.getParkingTicket());
    }

    @Test
    public void getReservationTicket() {
        Payment payment = new Payment(customer, reservationTicket, 5.00, 16);
        Assert.assertEquals(reservationTicket, payment.getReservationTicket());
    }

    @Test
    public void getAmount() {
        Payment payment = new Payment(customer, reservation, 5.00, 15);
        Assert.assertEquals(5.00, payment.getAmount(), 0.001);
    }

    @Test
    public void getPaymentStatus() {
        Payment payment = new Payment(customer, reservation, 5.00, 14);
        Assert.assertEquals(Status.PENDING, payment.getPaymentStatus());
    }

    @Test
    public void getPaymentDate() {
        Payment payment = new Payment(customer, reservation, 5.00, 13);
        Assert.assertNotNull(payment.getPaymentDate());
    }

    
}
