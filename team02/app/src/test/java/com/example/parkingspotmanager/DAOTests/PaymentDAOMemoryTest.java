package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.Payment;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.memorydao.PaymentDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PaymentDAOMemoryTest {

    private PaymentDAOMemory paymentDAOMemory;
    private Payment payment;
    private Customer customer;
    private Reservation reservation;
    private ParkingSpace parkingSpace;
    private ParkingBuilding parkingBuilding;

    @Before
    public void setUp() {
        paymentDAOMemory = new PaymentDAOMemory();
        paymentDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        parkingBuilding = new ParkingBuilding(1, "Building 1", "09:00", "22:00", "11111");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        reservation = new Reservation(parkingSpace, customer, LocalTime.now(), LocalTime.now().plusHours(2), 20.0);
        payment = new Payment(customer, reservation, 1, 2);
        paymentDAOMemory.save(payment);
    }

    @Test
    public void testFindAll() {
        ArrayList<Payment> payments = paymentDAOMemory.findAll();
        Assert.assertEquals(1, payments.size());
    }

    @Test
    public void testSave() {
        Customer newCustomer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        Reservation newReservation = new Reservation(parkingSpace, newCustomer, LocalTime.now(), LocalTime.now().plusHours(3), 30.0);
        Payment newPayment = new Payment(newCustomer, newReservation, 2, 3);
        paymentDAOMemory.save(newPayment);
        Assert.assertEquals(2, paymentDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        Payment foundPayment = paymentDAOMemory.find(payment.getPaymentID());
        Assert.assertNotNull(foundPayment);
        Assert.assertEquals(payment.getPaymentID(), foundPayment.getPaymentID());
    }

    @Test
    public void testDelete() {
        paymentDAOMemory.delete(payment);
        Assert.assertNull(paymentDAOMemory.find(1));
    }

    @Test
    public void testDeleteAll() {
        paymentDAOMemory.deleteAll();
        Assert.assertTrue(paymentDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testNextId() {
        paymentDAOMemory.deleteAll(); // Ensure the DAO is empty before the test
        int nextId = paymentDAOMemory.nextId();
        Assert.assertEquals(1, nextId);

        Customer newCustomer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        Reservation newReservation = new Reservation(parkingSpace, newCustomer, LocalTime.now(), LocalTime.now().plusHours(3), 30.0);
        Payment newPayment = new Payment(newCustomer, newReservation, nextId, 1);
        paymentDAOMemory.save(newPayment);

        nextId = paymentDAOMemory.nextId();
        Assert.assertEquals(2, nextId);
    }
}