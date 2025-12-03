package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.ParkingBuilding;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ParkingBuildingDAO {

    /**
     * Save a parking building
     * @param entity the parking building to be saved
     */
    void save(ParkingBuilding entity);

    /**
     * Find the next id
     */
    int nextId();

    /**
     * Find a parking building by id
     * @param parkingBuildingID the id of the parking building
     */
    ParkingBuilding find(int parkingBuildingID);

    /**
     * Delete a parking building
     * @param entity the parking building to be deleted
     */
    void delete(ParkingBuilding entity);

    /**
     * Delete all parking buildings
     */
    void deleteAll();

    /**
     * Find all parking buildings
     */
    ArrayList<ParkingBuilding> findAll();
}
