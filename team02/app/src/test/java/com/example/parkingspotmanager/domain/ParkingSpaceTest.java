package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ParkingSpaceTest {

    private ParkingBuilding parkingBuilding;
    private ParkingSpace parkingSpace;

    @Before
    public void setUp() {
        // Setup a ParkingBuilding object
        parkingBuilding = new ParkingBuilding(1, "Mitropoleos 12", "08:00", "20:00", "12345");

        // Setup a ParkingSpace object for testing
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 10.0);
    }

    @Test
    public void testConstructorAndGetters() {
        // Test if constructor initializes properly
        Assert.assertEquals(1, parkingSpace.getParkingSpaceId());
        Assert.assertEquals(parkingBuilding, parkingSpace.getParkingBuilding());
        Assert. assertFalse(parkingSpace.isOccupied());
        Assert.assertFalse(parkingSpace.isReserved());
        Assert.assertEquals(10.0, parkingSpace.getPricePerHour(), 0.01);
    }


    @Test
    public void testSetters() {
        // Change some properties using setters
        parkingSpace.setParkingSpaceId(2);
        parkingSpace.setParkingBuilding(new ParkingBuilding(2, "Ithakis 12", "08:00", "20:00", "12455"));
        parkingSpace.setOccupied(true);
        parkingSpace.setReserved(true);
        parkingSpace.setPricePerHour(12.5);

        // Assert changes are reflected
        Assert.assertEquals(2, parkingSpace.getParkingSpaceId());
        Assert.assertEquals( "Ithakis 12", parkingSpace.getParkingBuilding().getBuildingAddress());
        Assert.assertTrue(parkingSpace.isOccupied());
        Assert.assertTrue(parkingSpace.isReserved());
        Assert.assertEquals(12.5, parkingSpace.getPricePerHour(), 0.01);
    }
}
