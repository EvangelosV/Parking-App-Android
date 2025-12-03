package com.example.parkingspotmanager.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ParkingTicket {
    private int parkingTicketID;// Parking Ticket ID
    private ParkingSpace parkingSpace;// Parking Space
    private ParkingBuilding parkingBuilding;// Parking Building
    private LocalTime entryTime;// Entry Time
    private LocalTime exitTime;// Exit Time
    private double chargeAmount;// Charge Amount

    /**
     * Constructor for the Parking Ticket
     * @param parkingTicketID for the parking ticket
     * @param parkingSpace for the parking ticket
     * @param parkingBuilding for the parking ticket
     * @param entryTime for the parking ticket
     * @param exitTime for the parking ticket
     * @param chargeAmount for the parking ticket
     */
    public ParkingTicket(int parkingTicketID, ParkingSpace parkingSpace, ParkingBuilding parkingBuilding,
                         LocalTime entryTime, LocalTime exitTime, double chargeAmount) {
        this.parkingTicketID = parkingTicketID;
        this.parkingSpace = parkingSpace;
        this.parkingBuilding = parkingBuilding;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.chargeAmount = chargeAmount;
    }


    /**
     * get the parking ticket id
     * @return the parking ticket id
     */
    public int getParkingTicketID() {
        return parkingTicketID;
    }

    /**
     * set the parking ticket id
     * @param parkingTicketID the new parking ticket id
     */
    public void setParkingTicketID(int  parkingTicketID) {
        this.parkingTicketID = parkingTicketID;
    }

    /**
     * get the parking space
     * @return the parking space
     */
    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    /**
     * set the parking space
     * @param parkingSpace the new parking space
     */
    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    /**
     * get the parking building
     * @return the parking building
     */
    public ParkingBuilding getParkingBuilding() {
        return parkingBuilding;
    }

    /**
     * set the parking
     * @param parkingBuilding the new parking building
     */
    public void setParkingBuilding(ParkingBuilding parkingBuilding) {
        this.parkingBuilding = parkingBuilding;
    }

    /**
     * get the entry time
     * @return the entry time
     */
    public LocalTime getEntryTime() {
        return entryTime;
    }

    /**
     * set the entry time
     * @param entryTime the new entry time
     */
    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * get the exit time
     * @return the exit time
     */
    public LocalTime getExitTime() {
        return exitTime;
    }

    /**
     * set the exit time
     * @param exitTime the new exit time
     */
    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * get the charge amount
     * @return the charge amount
     */
    public double getChargeAmount() {
        return chargeAmount;
    }

    /**
     * set the charge amount
     * @param chargeAmount the new charge amount
     */
    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    /**
     * calculate the duration of parking
     * @return the duration of parking
     */
    public Duration getDuration() {
        if (entryTime != null && exitTime != null) {
            return Duration.between(entryTime, exitTime);
        } else {
            return Duration.ZERO; // Return zero duration if either entry or exit time is null
        }
    }
}
