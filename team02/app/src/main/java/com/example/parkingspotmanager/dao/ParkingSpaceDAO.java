package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.ParkingSpace;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ParkingSpaceDAO {

    /**
     * Save a parking space
     * @param entity the parking space to be saved
     */
    void save(ParkingSpace entity);

    /**
     * Find a parking space by id
     * @param spaceId the id of the parking space
     */
    ParkingSpace find(int spaceId);

    /**
     * Find all parking spaces
     */
    ArrayList<ParkingSpace> findAll();

    /**
     * Delete a parking space
     * @param entity the parking space to be deleted
     */
    void delete(ParkingSpace entity);

    /**
     * Delete all parking spaces
     */
    void deleteAll();

    ArrayList<ParkingSpace> findParkingSpacesByBuildingId(int buildingId);
}
