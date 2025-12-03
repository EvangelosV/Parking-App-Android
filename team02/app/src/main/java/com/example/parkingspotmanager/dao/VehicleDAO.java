package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Vehicle;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface VehicleDAO {

    /**
     * Delete all vehicles
     */
    void deleteAll();


    /**
     * Delete a vehicle
     * @param entity the vehicle to be deleted
     */
    void delete(Vehicle entity);

    /**
     * Find all vehicles
     */
    ArrayList<Vehicle> findAll();

    /**
     * Save a vehicle
     * @param entity the vehicle to be saved
     */
    void save(Vehicle entity);
}
