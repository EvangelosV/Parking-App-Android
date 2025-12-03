package com.example.parkingspotmanager.domain;

import com.example.parkingspotmanager.util.ParkingExceptions;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class Payment {
    private int paymentID;// Payment ID
    private Customer customer;// Customer
    private Reservation reservation;// Reservation
    private ParkingTicket parkingTicket;// Parking Ticket
    private ReservationTicket reservationTicket;// Reservation Ticket
    private LocalTime paymentDate;// Payment Date
    private double amount;// Amount
    private Status paymentStatus;// Payment Status


    /**
     * Constructor for the Payment with Reservation
     * @param customer for the payment
     * @param reservation for the payment
     * @param amount for the payment
     * @param paymentID for the payment
     */
    public Payment(Customer customer, Reservation reservation, double amount, int paymentID) {
        this.customer = customer;
        this.reservation = reservation;
        this.amount = amount;
        this.paymentStatus = Status.PENDING; // Default status
        this.paymentDate = LocalTime.now();
        this.paymentID = paymentID;
    }


    /**
     * Constructor for the Payment with Parking Ticket
     * @param customer for the payment
     * @param parkingTicket for the payment
     * @param amount for the payment
     * @param paymentID for the payment
     */
    public Payment(Customer customer, ParkingTicket parkingTicket, double amount, int paymentID) {
        this.customer = customer;
        this.parkingTicket = parkingTicket;
        this.amount = amount;
        this.paymentStatus = Status.PENDING; // Default status
        this.paymentDate = LocalTime.now();
        this.paymentID = paymentID;
    }

    /**
     * Constructor for the Payment with Reservation Ticket
     * @param customer for the payment
     * @param reservationTicket for the payment
     * @param amount for the payment
     * @param paymentID for the payment
     */
    public Payment(Customer customer, ReservationTicket reservationTicket, double amount, int paymentID) {
        this.customer = customer;
        this.reservationTicket = reservationTicket;
        this.amount = amount;
        this.paymentStatus = Status.PENDING; // Default status
        this.paymentDate = LocalTime.now();
        this.paymentID = paymentID;
    }

    /**
     * get the customer
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * set the customer
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
     * get the parking ticket
     * @return the parking ticket
     */
    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    /**
     * set the parking ticket
     * @param parkingTicket the new parking ticket
     */
    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    /**
     * get the reservation ticket
     * @return the reservation ticket
     */
    public ReservationTicket getReservationTicket() {
        return reservationTicket;
    }

    /**
     * set the reservation ticket
     * @param reservationTicket the new reservation ticket
     */
    public void setReservationTicket(ReservationTicket reservationTicket) {
        this.reservationTicket = reservationTicket;
    }

    /**
     * get the amount
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * set the amount
     * @param amount the new amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the payment status
     * @return the payment status
     */
    public Status getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * set the payment status
     * @param paymentStatus the new payment status
     */
    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * get the payment date
     * @return the payment date
     */
    public LocalTime getPaymentDate() {
        return paymentDate;
    }

    /**
     * set the payment date
     * @param paymentDate the new payment date
     */
    public void setPaymentDate(LocalTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * get the payment ID
     * @return the payment ID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * set the payment ID
     * @param paymentID the new payment ID
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * process the payment
     * @param customer the customer
     */
    public void processPayment(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }
        if (amount > customer.getAccountBalance()) {
            throw new ParkingExceptions();
        }
        customer.setAccountBalance(customer.getAccountBalance() - amount);
        setPaymentStatus(Status.APPROVED);
    }

    /**
     * update the payment status
     * @param status the new status
     */
    public void updatePaymentStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException();
        }
        setPaymentStatus(status);
    }

    /**
     * send the payment confirmation
     * @return the payment confirmation
     */
    public boolean sendPaymentConfirmation() {
        return this.paymentStatus == Status.APPROVED;
    }

}
