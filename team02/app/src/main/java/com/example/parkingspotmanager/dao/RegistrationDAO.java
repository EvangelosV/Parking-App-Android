package com.example.parkingspotmanager.dao;


import com.example.parkingspotmanager.domain.Registration;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface RegistrationDAO {

    /**
     * Save a registration
     * @param entity the registration to be saved
     */
    void save(Registration entity);


    /**
     * Find based username
     */
    Registration findByUsername(String username);

    /**
     * Delete a registration
     * @param entity the registration to be deleted
     */
    void delete(Registration entity);

    /**
     * Find all registrations
     */
    void deleteAll();

    /**
     * Find all pending registrations
     */
    ArrayList<Registration> findAllPending();

    /**
     * Find all approved registrations
     */
    ArrayList<Registration> findAllApproved();

}
