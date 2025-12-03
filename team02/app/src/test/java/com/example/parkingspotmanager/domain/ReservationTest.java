package com.example.parkingspotmanager.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class ReservationTest {

    private Reservation reservation;
    private Customer customer;
    private ParkingSpace parkingSpace;
    private ParkingBuilding parkingBuilding;
    private LocalTime entryDateTime;
    private LocalTime exitDateTime;

    @Before
    public void setUp() {
        // Setup for each test
        customer = new Customer("John", "Doe", "john@doe.gr", "0123456789", "JOHN","0123456789",new Vehicle("1234ABC", "Toyota", "Corolla"));  // Example constructor, adapt as necessary
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 2.0);  // Example constructor, adapt as necessary
        parkingBuilding = new ParkingBuilding(1, "Mitropoleos 12", "08:00", "20:00", "12345");
        entryDateTime = LocalTime.of(8, 0);
        exitDateTime = LocalTime.of(10, 0);
        reservation = new Reservation(parkingSpace, customer, entryDateTime, exitDateTime, 20.0);
    }

    @Test
    public void testReservationConstructorAndGetters() {
        assertNotNull(reservation);
        assertEquals(parkingSpace, reservation.getAssignedParkingSpace());
        assertEquals(customer, reservation.getCustomer());
        assertEquals(entryDateTime, reservation.getEntryTime());
        assertEquals(exitDateTime, reservation.getReservedExitTime());
        assertEquals(20.0, reservation.getReservedChargeAmount(), 0.01);
    }

    @Test
    public void testSetters() {
        reservation.setAssignedParkingSpace(new ParkingSpace(1, parkingBuilding, false, false, 2.0));  // New mock space
        reservation.setCustomer(new Customer("Kyriakos", "Grizzly", "maou@maou.gr", "0123456789", "KYRIAKOS","0123456789",new Vehicle("1234ABC", "Toyota", "Corolla")));  // New mock customer);
        reservation.setEntryTime(LocalTime.of(9, 0));
        reservation.setReservedExitTime(LocalTime.of(11, 0));
        reservation.setReservedChargeAmount(25.0);

        assertEquals(1, reservation.getAssignedParkingSpace().getParkingSpaceId());
        assertEquals("maou@maou.gr", reservation.getCustomer().getEmail());
        assertEquals(LocalDateTime.of(2024, 12, 5, 9, 0), reservation.getEntryTime());
        assertEquals(LocalDateTime.of(2024, 12, 5, 11, 0), reservation.getReservedExitTime());
        assertEquals(25.0, reservation.getReservedChargeAmount(), 0.01);
    }

    @Test
    public void testToString() {
        String expectedString = "Reservation{" +
                "assignedParkingSpace=" + parkingSpace + "," +
                "customer=" + customer + "," +
                "startTime=" + entryDateTime + "," +
                "endTime=" + exitDateTime + "," +
                "ReservedChargeAmount=20.0" +
                "}";
        assertEquals(expectedString, reservation.toString());
    }

    @Test
    public void testSetAndGetReservedChargeAmount() {
        reservation.setReservedChargeAmount(30.0);
        assertEquals(30.0, reservation.getReservedChargeAmount(), 0.0);
    }

}
