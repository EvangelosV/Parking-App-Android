package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.ParkingTicket;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ParkingTicketDAO {

    /**
     * Delete a parking ticket
     * @param entity the parking ticket to be deleted
     */
    void delete(ParkingTicket entity);

    /**
     * Find the next id
     */
    int nextId();

    /**
     * Find all parking tickets
     */
    ArrayList<ParkingTicket> findAll();

    /**
     * Save a parking ticket
     * @param entity the parking ticket to be saved
     */
    void save(ParkingTicket entity);

    /**
     * Find a parking ticket by id
     * @param ticketId the id of the parking ticket
     */
    ParkingTicket find(int ticketId);

    /**
     * Delete all parking tickets
     */
    void deleteAll();
}
