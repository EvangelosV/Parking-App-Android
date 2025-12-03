package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Payment;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface PaymentDAO {

    /**
     * Save a payment
     * @param entity the payment to be saved
     */
    void save(Payment entity);

    /**
     * Find a payment by id
     * @param paymentId the id of the payment
     */
    Payment find(int paymentId);

    /**
     * Delete a payment
     * @param entity the payment to be deleted
     */
    void delete(Payment entity);

    /**
     * Delete all payments
     */
    void deleteAll();

    /**
     * Find the next id
     */
    int nextId();

    /**
     * Find all payments
     */
    ArrayList<Payment> findAll();


}
