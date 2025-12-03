package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class ParkingBuildingTest {

    private ParkingBuilding parkingBuilding;

    @Before
    public void setUp() {
        // Create a new ParkingBuilding object before each test
        parkingBuilding = new ParkingBuilding(1, "123 Main St, City", "08:00", "20:00", "12345");
    }

    @Test
    public void testConstructor() {
        // Test constructor behavior
        Assert.assertEquals(1, parkingBuilding.getBuildingId());
        Assert.assertEquals("123 Main St, City", parkingBuilding.getBuildingAddress());
        Assert. assertEquals("08:00", parkingBuilding.getOpeningHours());
        Assert. assertEquals("20:00", parkingBuilding.getClosingHours());
        Assert.assertEquals("12345", parkingBuilding.getPostalCode());
    }

    @Test
    public void testGetters() {
        // Test getter methods
        Assert.assertEquals(1, parkingBuilding.getBuildingId());
        Assert.assertEquals("123 Main St, City", parkingBuilding.getBuildingAddress());
        Assert.assertEquals("08:00", parkingBuilding.getOpeningHours());
        Assert.assertEquals("20:00", parkingBuilding.getClosingHours());
        Assert.assertEquals("12345", parkingBuilding.getPostalCode());
    }

    @Test
    public void testSetters() {
        // Test setter methods
        parkingBuilding.setBuildingId(2);
        parkingBuilding.setBuildingAddress("456 Elm St, City");
        parkingBuilding.setOpeningHours("09:00");
        parkingBuilding.setClosingHours("22:00");
        parkingBuilding.setPostalCode("67890");

        Assert.assertEquals(2, parkingBuilding.getBuildingId());
        Assert.assertEquals("456 Elm St, City", parkingBuilding.getBuildingAddress());
        Assert.assertEquals("09:00", parkingBuilding.getOpeningHours());
        Assert.assertEquals("22:00", parkingBuilding.getClosingHours());
        Assert.assertEquals("67890", parkingBuilding.getPostalCode());
    }

    @Test
    public void testUpdateBuildingAddress() {
        // Test if the building address can be updated
        parkingBuilding.setBuildingAddress("789 Oak St, City");
        Assert.assertEquals("789 Oak St, City", parkingBuilding.getBuildingAddress());
    }

    @Test
    public void testUpdateOpeningHours() {
        // Test if the opening hours can be updated
        parkingBuilding.setOpeningHours("10:00");
        Assert.assertEquals("10:00", parkingBuilding.getOpeningHours());
    }
}
