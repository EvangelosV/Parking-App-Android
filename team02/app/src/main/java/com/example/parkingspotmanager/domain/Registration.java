package com.example.parkingspotmanager.domain;

import androidx.annotation.NonNull;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class Registration {
    private Status status;
    private Customer customer;

    /**
     * Constructor for the Registration
     * @param customer for the registration
     */
    public Registration(Customer customer) {
        this.customer = customer;
        status = Status.PENDING; // Default status
    }

    /**
     * Getter for the customer
     * @return the customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Setter for the customer
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter for the status
     * @return the status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Check if registration is approved
     * @return true if approved, false otherwise
     */
    public boolean isApproved() {
        return this.status == Status.APPROVED;
    }

    /**
     * Check if registration is rejected
     * @return true if pending, false otherwise
     */
    public boolean isRejected() {
        return this.status == Status.REJECTED;
    }

    /**
     * Setter for the status
     * @param status the new status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * toString method
     * @return the string representation of the object
     */
    @NonNull
    @Override
    public String toString() {
        return "Registration{" +
                "username='" + customer.getUsername() + '\'' +
                ", email='" + customer.getEmail() + '\'' +
                ", status=" + this.status +
                '}';
    }
}
