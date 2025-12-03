package com.example.parkingspotmanager.domain;

import androidx.annotation.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class ParkingSpace {
    private int parkingSpaceId;// Parking Space ID
    private ParkingBuilding parkingBuilding;// Parking Building
    private boolean isOccupied;// Is the parking space occupied
    private boolean isReserved;// Is the parking space reserved
    private double pricePerHour;// Price per hour

    /**
     * Constructor for the Parking Space
     * @param parkingSpaceId for the parking space
     * @param parkingBuilding for the parking space
     * @param isOccupied for the parking space
     * @param isReserved for the parking space
     * @param pricePerHour for the parking space
     */
    public ParkingSpace(int parkingSpaceId, ParkingBuilding parkingBuilding, boolean isOccupied, boolean isReserved, double pricePerHour) {
        this.parkingSpaceId = parkingSpaceId;
        this.parkingBuilding = parkingBuilding;
        this.parkingBuilding.increaseSpaces();
        this.isOccupied = isOccupied;
        this.isReserved = isReserved;
        this.pricePerHour = pricePerHour;
    }

    /**
     * get the parking space id
     * @return the parking space id
     */
    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    /**
     * set the parking space id
     * @param parkingSpaceId the new parking space id
     */
    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    /**
     * get the parking building
     * @return the parking building
     */
    public ParkingBuilding getParkingBuilding() {
        return parkingBuilding;
    }

    /**
     * set the parking building
     * @param parkingBuilding the new parking building
     */
    public void setParkingBuilding(ParkingBuilding parkingBuilding) {
        this.parkingBuilding = parkingBuilding;
    }

    /**
     * get the occupied status of the parking space
     * @return the occupied status
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * set the occupied status of the parking space
     * @param occupied the new occupied status
     */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    /**
     * get the reserved status of the parking space
     * @return the reserved status
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * set the reserved status of the parking space
     * @param reserved the new reserved status
     */
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    /**
     * get the price per hour of the parking space
     * @return the price per hour
     */
    public double getPricePerHour() {
        return pricePerHour;
    }

    /**
     * set the price per hour of the parking space
     * @param pricePerHour the new price per hour
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}

