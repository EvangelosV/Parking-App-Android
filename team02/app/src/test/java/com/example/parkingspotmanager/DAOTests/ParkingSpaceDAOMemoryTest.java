package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.memorydao.ParkingSpaceDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ParkingSpaceDAOMemoryTest {

    private ParkingSpaceDAOMemory parkingSpaceDAOMemory;
    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;

    @Before
    public void setUp() {
        parkingSpaceDAOMemory = new ParkingSpaceDAOMemory();
        parkingSpaceDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        parkingBuilding = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10);
        parkingSpaceDAOMemory.save(parkingSpace);
    }

    @Test
    public void testFindAll() {
        ArrayList<ParkingSpace> parkingSpaces = parkingSpaceDAOMemory.findAll();
        Assert.assertEquals(1, parkingSpaces.size());
    }

    @Test
    public void testSave() {
        ParkingSpace newParkingSpace = new ParkingSpace(2, parkingBuilding, false, false, 15);
        parkingSpaceDAOMemory.save(newParkingSpace);
        Assert.assertEquals(2, parkingSpaceDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        ParkingSpace foundParkingSpace = parkingSpaceDAOMemory.find(1);
        Assert.assertNotNull(foundParkingSpace);
        Assert.assertEquals(1, foundParkingSpace.getParkingSpaceId());
    }

    @Test
    public void testDelete() {
        parkingSpaceDAOMemory.delete(parkingSpace);
        Assert.assertNull(parkingSpaceDAOMemory.find(1));
    }

    @Test
    public void testDeleteAll() {
        parkingSpaceDAOMemory.deleteAll();
        Assert.assertTrue(parkingSpaceDAOMemory.findAll().isEmpty());
    }


    @Test
    public void testFindParkingSpacesByBuildingId() {
        parkingSpaceDAOMemory.deleteAll(); // Ensure the DAO is empty before the test
        ParkingBuilding building1 = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        ParkingBuilding building2 = new ParkingBuilding(2, "456 Elm St", "09:00", "21:00", "10002");
        ParkingSpace parkingSpace1 = new ParkingSpace(1, building1, false, false, 10);
        ParkingSpace parkingSpace2 = new ParkingSpace(2, building1, false, false, 15);
        ParkingSpace parkingSpace3 = new ParkingSpace(3, building2, false, false, 20);
        parkingSpaceDAOMemory.save(parkingSpace1);
        parkingSpaceDAOMemory.save(parkingSpace2);
        parkingSpaceDAOMemory.save(parkingSpace3);

        ArrayList<ParkingSpace> spacesByBuilding1 = parkingSpaceDAOMemory.findParkingSpacesByBuildingId(1);
        Assert.assertEquals(2, spacesByBuilding1.size());

        ArrayList<ParkingSpace> spacesByBuilding2 = parkingSpaceDAOMemory.findParkingSpacesByBuildingId(2);
        Assert.assertEquals(1, spacesByBuilding2.size());
    }
}