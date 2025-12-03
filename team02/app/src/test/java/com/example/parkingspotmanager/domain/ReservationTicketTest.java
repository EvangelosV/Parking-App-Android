package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationTicketTest {

    private Reservation reservation;
    private ReservationTicket reservationTicket;
    private LocalTime entryTime;
    private LocalTime exitTime;

    @Before
    public void setUp() {
        entryTime = LocalTime.of(8, 0);
        exitTime = LocalTime.of(10, 0);

        // Mock reservation object
        Customer customer = new Customer("Nikos","Nikolaidis","maou@maou.gr","12345678","Magkomeni","0123456789", new Vehicle("1234ABC", "Toyota", "Corolla"));
        ParkingBuilding parkingBuilding = new ParkingBuilding(1, "Mitropoleos 12", "08:00", "20:00", "12345");
        ParkingSpace parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 2.0);  // Example constructor, adapt as necessary
        reservation =  new Reservation(parkingSpace, customer, entryTime, exitTime, 20.0);

        // Create a ReservationTicket instance
        reservationTicket = new ReservationTicket(reservation, entryTime, exitTime, 40.0);
    }

    @Test
    public void testGetReservation() {
        Assert.assertEquals(reservation, reservationTicket.getReservation());
    }

    @Test
    public void testSetReservation() {
        Vehicle vehicle = new Vehicle("1234ABC", "Toyota", "Yaris");
        Customer newCustomer = new Customer("Nikos","Nikolaidis","maou@maou.gr","12345678","Magkomeni","0123456789", new Vehicle("1234ABC", "Toyota", "Corolla"));
        ParkingBuilding newParkingBuilding = new ParkingBuilding(3, "Ithakis 12", "08:00", "20:00", "6767");
        ParkingSpace newParkingSpace = new ParkingSpace(2, newParkingBuilding, false, false, 2.0);
        LocalTime newEntryTime = LocalTime.of(8, 0);
        LocalTime newExitTime = LocalTime.of(10, 0);
        Reservation newReservation = new Reservation(newParkingSpace, newCustomer, newEntryTime, newExitTime, 20.0);
        reservationTicket.setReservation(newReservation);
        Assert.assertEquals(newReservation, reservationTicket.getReservation());
    }

    @Test
    public void testGetExitTime() {
        Assert.assertEquals(exitTime, reservationTicket.getExitTime());
    }

    @Test
    public void testSetExitTime() {
        LocalTime newExitTime = exitTime.plusHours(1);
        reservationTicket.setExitTime(newExitTime);
        Assert.assertEquals(newExitTime, reservationTicket.getExitTime());
    }

    @Test
    public void testGetChargeAmount() {
        Assert.assertEquals(40.0, reservationTicket.getChargeAmount(), 0.01);
    }

    @Test
    public void testSetChargeAmount() {
        reservationTicket.setChargeAmount(50.0);
        Assert.assertEquals(50.0, reservationTicket.getChargeAmount(), 0.01);
    }

    @Test
    public void testGetDuration() {
        Duration expectedDuration = Duration.between(entryTime, exitTime);
        Assert.assertEquals(expectedDuration, reservationTicket.getDuration());
    }

    @Test
    public void testGetDurationWithInvalidTimes() {
        reservationTicket.setExitTime(null);
        Assert.assertEquals(Duration.ZERO, reservationTicket.getDuration());
    }
}
