package com.example.parkingspotmanager.domain;

import com.example.parkingspotmanager.memorydao.ParkingSpaceDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationTicketDAOMemory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class Customer extends User {

    private Vehicle vehicle;// Vehicle of the customer
    private double accountBalance;// Account balance of the customer
    private ParkingSpaceDAOMemory parkingSpaceController = new ParkingSpaceDAOMemory();
    private ReservationDAOMemory reservationController = new ReservationDAOMemory();
    private ReservationTicketDAOMemory reservationTicketController = new ReservationTicketDAOMemory();
    private List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
    private List<Reservation> reservations = new ArrayList<Reservation>();


    /**
     * the full constructor
     * @param FirstName of the customer
     * @param LastName of the customer
     * @param email of the customer
     * @param phoneNumber of the customer
     * @param username of the customer
     * @param password of the customer
     * @param vehicle of the customer
     */
    public Customer(String FirstName, String LastName, String email, String phoneNumber, String username, String password, Vehicle vehicle) {
        super(FirstName, LastName, email, phoneNumber, username, password);
        this.vehicle = vehicle;
        this.accountBalance = 0;
    }

    /**
     * Getter for the account balance
     * @return the account balance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Setter for the account balance
     * @param accountBalance the new account balance
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**Getter for the vehicle
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Setter for the vehicle
     * @param vehicle the new vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Books a parking spot in the specified parking building for the given time interval.
     *
     * @param parkingBuilding The parking building where the spot is to be booked.
     * @param entryTime The entry time for the reservation.
     * @param exitTime The exit time for the reservation.
     * @return true if a parking spot is successfully booked, false otherwise.
     */
    public boolean bookParkingSpot(ParkingBuilding parkingBuilding, LocalTime entryTime, LocalTime exitTime) {
        parkingSpaces = parkingSpaceController.findParkingSpacesByBuildingId(parkingBuilding.getBuildingId());
        reservations = reservationController.findReservationsByBuildingId(parkingBuilding.getBuildingId());

        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (isParkingSpaceAvailable(parkingSpace, reservations, entryTime, exitTime)) {
                createReservation(parkingSpace, entryTime, exitTime);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a parking space is available for the given time interval.
     *
     * @param parkingSpace The parking space to check for availability.
     * @param reservations The list of existing reservations for the parking building.
     * @param entryTime The entry time for the desired reservation.
     * @param exitTime The exit time for the desired reservation.
     * @return true if the parking space is available, false otherwise.
     */
    private boolean isParkingSpaceAvailable(ParkingSpace parkingSpace, List<Reservation> reservations, LocalTime entryTime, LocalTime exitTime) {
        for (Reservation reservation : reservations) {
            if (reservation.getAssignedParkingSpace().equals(parkingSpace) &&
                    isOverlapping(entryTime, exitTime, reservation.getEntryTime(), reservation.getReservedExitTime())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new reservation for the specified parking space and time interval.
     *
     * @param parkingSpace The parking space to be reserved.
     * @param entryTime The entry time for the reservation.
     * @param exitTime The exit time for the reservation.
     */
    private void createReservation(ParkingSpace parkingSpace, LocalTime entryTime, LocalTime exitTime) {
        long duration = Math.max(1, java.time.Duration.between(entryTime, exitTime).toHours());
        double totalCharge = duration * parkingSpace.getPricePerHour();

        Reservation newReservation = new Reservation(parkingSpace, this, entryTime, exitTime, parkingSpace.getPricePerHour());
        ReservationTicket ticket = new ReservationTicket(newReservation, entryTime, exitTime, totalCharge);

        reservationController.save(newReservation);
        reservationTicketController.save(ticket);
    }

    /**
     * Checks if two time intervals overlap.
     *
     * @param start1 The start time of the first interval.
     * @param end1 The end time of the first interval.
     * @param start2 The start time of the second interval.
     * @param end2 The end time of the second interval.
     * @return true if the intervals overlap, false otherwise.
     */
    private boolean isOverlapping(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }
}

