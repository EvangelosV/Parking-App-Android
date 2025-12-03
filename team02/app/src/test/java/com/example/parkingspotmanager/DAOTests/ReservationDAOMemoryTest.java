package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.memorydao.ReservationDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOMemoryTest {

    private ReservationDAOMemory reservationDAOMemory;
    private Reservation reservation;
    private Customer customer;
    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;

    @Before
    public void setUp() {
        reservationDAOMemory = new ReservationDAOMemory();
        reservationDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        customer = new Customer("John", "Doe", "john.doe@company.com", "1234567890", "john_doe", "password123", null);
        parkingBuilding = new ParkingBuilding(1, "Building 1", "09:00", "22:00", "11111");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        reservation = new Reservation(parkingSpace, customer, LocalTime.now(), LocalTime.now().plusHours(2), 20.0);
        reservationDAOMemory.save(reservation);
    }

    @Test
    public void testFindAll() {
        ArrayList<Reservation> reservations = (ArrayList<Reservation>) reservationDAOMemory.findAll();
        Assert.assertEquals(1, reservations.size());
    }

    @Test
    public void testSave() {
        customer = new Customer("Jane", "Doe", "jane.doe@company.com", "0987654321", "jane_doe", "password456", null);
        parkingBuilding = new ParkingBuilding(1, "Building 1", "09:00", "22:00", "11111");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        Reservation newReservation = new Reservation(parkingSpace, customer,LocalTime.now(), LocalTime.now().plusHours(2), 20.0);
        reservationDAOMemory.save(newReservation);
        Assert.assertEquals(2, reservationDAOMemory.findAll().size());
    }

    @Test
    public void testFindReservationsByParkingSpaceId() {
        List<Reservation> reservations = reservationDAOMemory.findReservationsByParkingSpaceId(parkingSpace.getParkingSpaceId());
        Assert.assertEquals(1, reservations.size());
        Assert.assertEquals(parkingSpace.getParkingSpaceId(), reservations.get(0).getAssignedParkingSpace().getParkingSpaceId());
    }

    @Test
    public void testFindReservationsByUsername() {
        List<Reservation> reservations = reservationDAOMemory.findReservationsByUsername(customer.getUsername());
        Assert.assertEquals(1, reservations.size());
        Assert.assertEquals(customer.getUsername(), reservations.get(0).getCustomer().getUsername());
    }

    @Test
    public void testFindReservationsByBuildingId() {
        List<Reservation> reservations = reservationDAOMemory.findReservationsByBuildingId(parkingBuilding.getBuildingId());
        Assert.assertEquals(1, reservations.size());
        Assert.assertEquals(parkingBuilding.getBuildingId(), reservations.get(0).getAssignedParkingSpace().getParkingBuilding().getBuildingId());
    }

    @Test
    public void testDelete() {
        reservationDAOMemory.delete(reservation);
        Assert.assertTrue(reservationDAOMemory.findReservationsByUsername("john_doe").isEmpty());
    }


    @Test
    public void testDeleteAll() {
        reservationDAOMemory.deleteAll();
        Assert.assertTrue(reservationDAOMemory.findAll().isEmpty());
    }


}