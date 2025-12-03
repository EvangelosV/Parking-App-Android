package com.example.parkingspotmanager.domain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;

public class ParkingTicketTest {

    private ParkingTicket parkingTicket;
    private ParkingSpace parkingSpace;
    private ParkingBuilding parkingBuilding;
    private LocalTime entryTime;
    private LocalTime exitTime;

    @Before
    public void setUp() {
        parkingBuilding = new ParkingBuilding(1, "Mitropoleos 12", "08:00", "20:00", "12345");
        parkingSpace = new ParkingSpace(1, parkingBuilding, false, false, 2.0);
        entryTime = LocalTime.of(8, 0);
        exitTime = LocalTime.of(10, 0);
        parkingTicket = new ParkingTicket(123, parkingSpace, parkingBuilding, entryTime, exitTime, 10.0);
    }

    @Test
    public void testGetParkingTicketID() {
        Assert.assertEquals(123, parkingTicket.getParkingTicketID());
    }

    @Test
    public void testSetParkingTicketID() {
        parkingTicket.setParkingTicketID(456);
        Assert.assertEquals(456, parkingTicket.getParkingTicketID());
    }

    @Test
    public void testGetParkingSpace() {
        Assert.assertEquals(parkingSpace, parkingTicket.getParkingSpace());
    }

    @Test
    public void testSetParkingSpace() {
        ParkingSpace newParkingSpace = new ParkingSpace(2, parkingBuilding, true, false, 3.0);
        parkingTicket.setParkingSpace(newParkingSpace);
        Assert.assertEquals(newParkingSpace, parkingTicket.getParkingSpace());
    }

    @Test
    public void testGetParkingBuilding() {
        Assert.assertEquals(parkingBuilding, parkingTicket.getParkingBuilding());
    }

    @Test
    public void testSetParkingBuilding() {
        ParkingBuilding newParkingBuilding = new ParkingBuilding(2, "Ithakis 12", "08:00", "20:00", "12455");
        parkingTicket.setParkingBuilding(newParkingBuilding);
        Assert.assertEquals(newParkingBuilding, parkingTicket.getParkingBuilding());
    }

    @Test
    public void testGetEntryTime() {
        Assert.assertEquals(entryTime, parkingTicket.getEntryTime());
    }

    @Test
    public void testSetEntryTime() {
        LocalTime newEntryTime = LocalTime.of(9, 0);
        parkingTicket.setEntryTime(newEntryTime);
        Assert.assertEquals(newEntryTime, parkingTicket.getEntryTime());
    }

    @Test
    public void testGetExitTime() {
        Assert.assertEquals(exitTime, parkingTicket.getExitTime());
    }

    @Test
    public void testSetExitTime() {
        LocalTime newExitTime = LocalTime.of(11, 0);
        parkingTicket.setExitTime(newExitTime);
        Assert.assertEquals(newExitTime, parkingTicket.getExitTime());
    }

    @Test
    public void testGetChargeAmount() {
        Assert.assertEquals(10.0, parkingTicket.getChargeAmount(), 0.0);
    }

    @Test
    public void testSetChargeAmount() {
        parkingTicket.setChargeAmount(15.0);
        Assert.assertEquals(15.0, parkingTicket.getChargeAmount(), 0.0);
    }

    @Test
    public void testGetDuration() {
        Duration expectedDuration = Duration.between(entryTime, exitTime);
        Assert.assertEquals(expectedDuration, parkingTicket.getDuration());
    }

    @Test
    public void testDurationWhenNoExitTime() {
        parkingTicket.setExitTime(null);
        Assert.assertEquals(Duration.ZERO, parkingTicket.getDuration());
    }
}
