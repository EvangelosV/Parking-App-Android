package com.example.parkingspotmanager.domain;

import com.example.parkingspotmanager.util.ParkingExceptions;

import java.time.LocalDateTime;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class Renewal {
    private Customer customer;
    private double amount;
    private LocalDateTime renewalDate;
    private Status renewalStatus;
    private Payment payment;

    /**
     * Constructor for the Renewal
     * @param customer for the renewal
     * @param amount for the renewal
     */
    public Renewal(Customer customer, Double amount) {
        this.customer = customer;
        this.amount = amount;
        this.renewalStatus = Status.PENDING; // Default status
        this.renewalDate = LocalDateTime.now();
    }

    /**
     * Getter for the customer
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter for the amount
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter for the amount
     * @param amount the new amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter for the renewal date
     * @return the renewal date
     */
    public LocalDateTime getRenewalDate() {
        return renewalDate;
    }

    /**
     * Setter for the renewal date
     * @param renewalDate the new renewal date
     */
    public void setRenewalDate(LocalDateTime renewalDate) {
        this.renewalDate = renewalDate;
    }

    /**
     * Getter for the renewal status
     * @return the renewal status
     */
    public Status getRenewalStatus() {
        return renewalStatus;
    }

    /**
     * Setter for the renewal status
     * @param renewalStatus the new renewal status
     */
    public void setRenewalStatus(Status renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    /**
     * Getter for the payment
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Setter for the payment
     * @param payment the new payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Processes the renewal of a customer's account based on payment and renewal status.
     * If the renewal is PENDING, it updates the account balance and sets the renewal status
     * to APPROVED or REJECTED based on the payment status. Throws ParkingExceptions if the
     * renewal is already processed.
     */
    public void processRenewal () {
        if (getRenewalStatus() == Status.PENDING) {
            if (getPayment() != null) {
                if (getPayment().getPaymentStatus() == Status.APPROVED) {
                    getCustomer().setAccountBalance(this.customer.getAccountBalance() + this.amount);
                    setRenewalStatus(Status.APPROVED);
                } else if (this.payment.getPaymentStatus() == Status.REJECTED) {
                    setRenewalStatus(Status.REJECTED);
                }
            } else {
                getCustomer().setAccountBalance(this.customer.getAccountBalance() + this.amount);
                setRenewalStatus(Status.APPROVED);
            }
        } else {
            throw new ParkingExceptions("Renewal has already been processed");
        }
    }
}
