package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Renewal;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface RenewalDAO {

    /**
     * Save a renewal
     * @param entity the renewal to be saved
     */
    void save(Renewal entity);


    /**
     * Find all renewals
     */
    ArrayList<Renewal> findAll();

    /**
     * Delete a renewal
     * @param entity the renewal to be deleted
     */
    void delete(Renewal entity);

    /**
     * Delete all renewals
     */
    void deleteAll();

    /**
     * Find the next id
     */
    int nextId();
}
