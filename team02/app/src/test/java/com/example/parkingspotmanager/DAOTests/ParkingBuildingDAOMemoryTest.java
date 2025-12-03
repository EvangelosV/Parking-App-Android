package com.example.parkingspotmanager.DAOTests;

import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.memorydao.ParkingBuildingDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ParkingBuildingDAOMemoryTest {

    private ParkingBuildingDAOMemory parkingBuildingDAOMemory;
    private ParkingBuilding parkingBuilding;

    @Before
    public void setUp() {
        parkingBuildingDAOMemory = new ParkingBuildingDAOMemory();
        parkingBuildingDAOMemory.deleteAll(); // Ensure the DAO is empty before each test
        parkingBuilding = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        parkingBuildingDAOMemory.save(parkingBuilding);
    }

    @Test
    public void testFindAll() {
        ArrayList<ParkingBuilding> parkingBuildings = parkingBuildingDAOMemory.findAll();
        Assert.assertEquals(1, parkingBuildings.size());
    }

    @Test
    public void testSave() {
        ParkingBuilding newParkingBuilding = new ParkingBuilding(2, "456 Elm St", "09:00", "21:00", "10002");
        parkingBuildingDAOMemory.save(newParkingBuilding);
        Assert.assertEquals(2, parkingBuildingDAOMemory.findAll().size());
    }

    @Test
    public void testFind() {
        ParkingBuilding foundParkingBuilding = parkingBuildingDAOMemory.find(1);
        Assert.assertNotNull(foundParkingBuilding);
        Assert.assertEquals(1, foundParkingBuilding.getId());
    }

    @Test
    public void testDelete() {
        parkingBuildingDAOMemory.delete(parkingBuilding);
        Assert.assertNull(parkingBuildingDAOMemory.find(1));
    }

    @Test
    public void testDeleteAll() {
        parkingBuildingDAOMemory.deleteAll();
        Assert.assertTrue(parkingBuildingDAOMemory.findAll().isEmpty());
    }

    @Test
    public void testNextId() {
        parkingBuildingDAOMemory.deleteAll(); // Ensure the DAO is empty before the test
        int nextId = parkingBuildingDAOMemory.nextId();
        Assert.assertEquals(1, nextId);

        ParkingBuilding parkingBuilding = new ParkingBuilding(nextId, "123 Main St", "08:00", "22:00", "10001");
        parkingBuildingDAOMemory.save(parkingBuilding);

        nextId = parkingBuildingDAOMemory.nextId();
        Assert.assertEquals(2, nextId);
    }

    @Test
    public void testFindByZipCode() {
        parkingBuildingDAOMemory.deleteAll(); // Ensure the DAO is empty before the test
        ParkingBuilding parkingBuilding1 = new ParkingBuilding(1, "123 Main St", "08:00", "22:00", "10001");
        ParkingBuilding parkingBuilding2 = new ParkingBuilding(2, "456 Elm St", "09:00", "21:00", "10002");
        parkingBuildingDAOMemory.save(parkingBuilding1);
        parkingBuildingDAOMemory.save(parkingBuilding2);

        ArrayList<ParkingBuilding> buildingsByZip = parkingBuildingDAOMemory.findByZipCode("10001");
        Assert.assertEquals(1, buildingsByZip.size());
        Assert.assertEquals("123 Main St", buildingsByZip.get(0).getAddress());
    }
}