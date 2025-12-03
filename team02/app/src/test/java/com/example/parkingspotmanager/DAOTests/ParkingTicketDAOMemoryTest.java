package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.ParkingTicket;
import com.example.parkingspotmanager.memorydao.ParkingTicketDAOMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

public class ParkingTicketDAOMemoryTest {

    private ParkingTicketDAOMemory parkingTicketDAOMemory;
    private ParkingTicket parkingTicket;

    @Before
    public void setUp() {
        parkingTicketDAOMemory = new ParkingTicketDAOMemory();
        parkingTicketDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        ParkingBuilding parkingBuilding = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        ParkingSpace parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        parkingTicket = new ParkingTicket(1, parkingSpace, parkingBuilding, LocalTime.now(), LocalTime.now().plusHours(2), 20);
        parkingTicketDAOMemory.save(parkingTicket);
    }

    @Test
    public void testFindAll() {
        ArrayList<ParkingTicket> parkingTickets = parkingTicketDAOMemory.findAll();
        Assert.assertEquals(1, parkingTickets.size());
    }

    @Test
    public void testSave() {
        ParkingBuilding parkingBuilding = new ParkingBuilding(2, "456 Elm St", "09:00", "21:00", "10002");
        ParkingSpace parkingSpace = new ParkingSpace(2, parkingBuilding, false, false, 15);
        ParkingTicket newParkingTicket = new ParkingTicket(2, parkingSpace,parkingBuilding, LocalTime.now(), LocalTime.now().plusHours(3), 30);
        parkingTicketDAOMemory.save(newParkingTicket);
        Assert.assertEquals(2, parkingTicketDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        ParkingTicket foundParkingTicket = parkingTicketDAOMemory.find(1);
        Assert.assertNotNull(foundParkingTicket);
        Assert.assertEquals(1, foundParkingTicket.getParkingTicketID());
    }

    @Test
    public void testDelete() {
        parkingTicketDAOMemory.delete(parkingTicket);
        Assert.assertNull(parkingTicketDAOMemory.find(1));
    }

    @Test
    public void testDeleteAll() {
        parkingTicketDAOMemory.deleteAll();
        Assert.assertTrue(parkingTicketDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testNextId() {
        parkingTicketDAOMemory.deleteAll(); // Ensure the DAO is empty before the test
        int nextId = parkingTicketDAOMemory.nextId();
        Assert.assertEquals(1, nextId);

        ParkingBuilding parkingBuilding = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        ParkingSpace parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        ParkingTicket newParkingTicket = new ParkingTicket(nextId, parkingSpace, parkingBuilding, LocalTime.now(), LocalTime.now().plusHours(2), 20);
        parkingTicketDAOMemory.save(newParkingTicket);

        nextId = parkingTicketDAOMemory.nextId();
        Assert.assertEquals(2, nextId);
    }
}