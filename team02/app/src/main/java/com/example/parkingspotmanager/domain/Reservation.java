package com.example.parkingspotmanager.domain;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class Reservation {
    private ParkingSpace assignedParkingSpace;
    private Customer customer;
    private LocalTime entryDateTime;
    private LocalTime ReservedExitTime;
    private double ReservedChargeAmount;


    /**
     * Constructor for the Reservation
     * @param assignedParkingSpace for the reservation
     * @param customer for the reservation
     * @param entryDateTime for the reservation
     * @param ReservedExitTime for the reservation
     * @param ReservedChargeAmount for the reservation
     */
    public Reservation(ParkingSpace assignedParkingSpace, Customer customer, LocalTime entryDateTime, LocalTime ReservedExitTime, double ReservedChargeAmount) {
        this.assignedParkingSpace = assignedParkingSpace;
        assignedParkingSpace.setReserved(true);
        assignedParkingSpace.setOccupied(true);
        assignedParkingSpace.getParkingBuilding().decreaseSpaces();
        this.customer = customer;
        this.entryDateTime = entryDateTime;
        this.ReservedExitTime = ReservedExitTime;
        this.ReservedChargeAmount = ReservedChargeAmount;
    }

    /**
     * Getter for the assigned parking space
     * @return the assigned parking space
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the assigned parking space
     * @param customer the new assigned parking space
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    /**
     * Getter for the entry time
     *
     * @return the entry time
     */
    public LocalTime getEntryTime() {
        return entryDateTime;
    }

    /**
     * Setter for the entry time
     * @param entryDateTime the new entry time
     */
    public void setEntryTime(LocalTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * Getter for the exit time
     *
     * @return the exit time
     */
    public LocalTime getReservedExitTime() {
        return ReservedExitTime;
    }

    /**
     * Setter for the exit time
     * @param ReservedExitTime the new exit time
     */
    public void setReservedExitTime(LocalTime ReservedExitTime) {
        this.ReservedExitTime = ReservedExitTime;
    }

    /**
     * Getter for the assigned parking space
     * @return the assigned parking space
     */
    public ParkingSpace getAssignedParkingSpace() {
        return assignedParkingSpace;
    }

    /**
     * Setter for the assigned parking space
     * @param assignedParkingSpace the new assigned parking space
     */
    public void setAssignedParkingSpace(ParkingSpace assignedParkingSpace) {
        this.assignedParkingSpace = assignedParkingSpace;
    }


    /**
     * Getter for the reserved charge amount
     * @return the reserved charge amount
     */
    public double getReservedChargeAmount() {
        return ReservedChargeAmount;
    }

    /**
     * Setter for the reserved charge amount
     * @param ReservedChargeAmount the new reserved charge amount
     */
    public void setReservedChargeAmount(double ReservedChargeAmount) {
        this.ReservedChargeAmount = ReservedChargeAmount;
    }

    /**
     * toString method for the Reservation
     * @return the string representation of the Reservation
     */
    @NonNull
    @Override
    public String toString() {
        return "Reservation{" +
                "assignedParkingSpace=" + assignedParkingSpace + // Ensure ParkingSpace has a meaningful toString
                ",customer=" + customer + // Ensure Customer has a meaningful toString
                ",startTime=" + entryDateTime +
                ",endTime=" + ReservedExitTime +
                ",ReservedChargeAmount=" + ReservedChargeAmount +
                '}';
    }

}
