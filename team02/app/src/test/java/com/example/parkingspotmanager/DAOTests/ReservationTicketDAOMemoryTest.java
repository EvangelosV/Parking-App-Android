package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.ReservationTicket;
import com.example.parkingspotmanager.memorydao.ReservationTicketDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationTicketDAOMemoryTest {

    private ReservationTicketDAOMemory reservationTicketDAOMemory;
    private ReservationTicket reservationTicket;
    private Customer customer;
    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;
    private Reservation reservation;

    @Before
    public void setUp() {
        reservationTicketDAOMemory = new ReservationTicketDAOMemory();
        reservationTicketDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        parkingBuilding = new ParkingBuilding(1, "Building 1", "09:00", "22:00", "11111");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        reservation = new Reservation(parkingSpace, customer, LocalTime.now(), LocalTime.now().plusHours(2), 20.0);
        reservationTicket = new ReservationTicket(reservation, LocalTime.now(), LocalTime.now().plusHours(2), 20.0);
        reservationTicketDAOMemory.save(reservationTicket);
    }

    @Test
    public void testFindAll() {
        List<ReservationTicket> reservationTickets = reservationTicketDAOMemory.findAll();
        Assert.assertEquals(1, reservationTickets.size());
    }

    @Test
    public void testSave() {
        Customer newCustomer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        ParkingSpace newParkingSpace = new ParkingSpace(2, parkingBuilding, false, false, 15);
        reservation = new Reservation(newParkingSpace, newCustomer, LocalTime.now(), LocalTime.now().plusHours(3), 30.0);
        ReservationTicket newReservationTicket = new ReservationTicket(reservation, LocalTime.now(), LocalTime.now().plusHours(3), 30.0);
        reservationTicketDAOMemory.save(newReservationTicket);
        Assert.assertEquals(2, reservationTicketDAOMemory.findAll().size());
    }



    @Test
    public void testDeleteAll() {
        reservationTicketDAOMemory.deleteAll();
        Assert.assertTrue(reservationTicketDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testGetEntryExitTimes() {
        List<LocalTime[]> entryExitTimes = reservationTicketDAOMemory.getEntryExitTimes(parkingSpace.getParkingSpaceId());
        Assert.assertEquals(1, entryExitTimes.size());
        Assert.assertEquals(reservationTicket.getStartTime(), entryExitTimes.get(0)[0]);
        Assert.assertEquals(reservationTicket.getExitTime(), entryExitTimes.get(0)[1]);
    }

}