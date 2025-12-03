package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Management;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ManagementDAO {
    /**
     * Save a management
     * @param entity the management to be saved
     */
    void save(Management entity);

    /**
     * Delete a management entity
     * @param entity the management to be deleted
     */
    void delete(Management entity);

    /**
     * Find a management by credentials
     * @param credentials the credentials of the management
     */
    Management findByCredentials(Credentials credentials);

    /**
     * Find all managements accounts
     */
    ArrayList<Management> findAll();

    /**
     * Delete all management accounts
     */
    void deleteAll();

    /**
     * Find a management by username
     * @param username the username of the management
     * @return the management account
     */
    Management find(String username);
}
