package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Customer;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface CustomerDAO {

    /**
     * Save a customer
     * @param entity
     */
    void save(Customer entity);

    /**
     * Find a customer by username
     * @param customerUsername the username of the customer
     */
    Customer find(String customerUsername);

    /**
     * Find a customer by credentials
     * @param credentials the credentials of the customer
     */
    Customer findByCredentials(Credentials credentials);

    /**
     * Delete a customer
     * @param entity the customer to be deleted
     */
    void delete(Customer entity);

    /**
     * Find all customers
     */
    ArrayList<Customer> findAll();

    /**
     * Find a customer by email
     * @param email the email of the customer
     */
    Customer findByEmail(String email);

    /**
     * Find a customer by phone
     * @param phone the phone of the customer
     */
    Customer findByPhone(String phone);

    /**
     * Delete all customers
     */
    void deleteAll();
}
