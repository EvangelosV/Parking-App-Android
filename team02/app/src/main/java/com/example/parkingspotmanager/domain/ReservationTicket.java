package com.example.parkingspotmanager.domain;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ReservationTicket {

    private Reservation reservation;

    private LocalTime exitTime;
    private LocalTime startTime;

    private double chargeAmount;

    /**
     * Constructor for the Reservation Ticket
     * @param reservation for the reservation ticket
     * @param exitTime for the reservation ticket
     * @param chargeAmount for the reservation ticket
     */
    public ReservationTicket(Reservation reservation, LocalTime startTime, LocalTime exitTime, double chargeAmount) {
        this.reservation = reservation;
        this.startTime = startTime;
        this.exitTime = exitTime;
        this.chargeAmount = chargeAmount;
    }


    /**
     * get the reservation
     * @return the reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * set the reservation
     * @param reservation the new reservation
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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
     * get the start time
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * set the start time
     * @param startTime the new start time
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
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
     * get the duration
     * @return the duration
     */
    public Duration getDuration() {
        if (getReservation().getEntryTime() != null && exitTime != null) {
            return Duration.between(getReservation().getEntryTime(), exitTime);
        } else {
            return Duration.ZERO; // No valid duration if start or end time is missing } }
        }
    }
}
