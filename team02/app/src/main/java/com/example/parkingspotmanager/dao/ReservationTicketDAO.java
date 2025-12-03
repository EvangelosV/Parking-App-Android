package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.ReservationTicket;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ReservationTicketDAO {

    /**
     * Save a reservation ticket
     * @param entity the reservation ticket to be saved
     */
    void save(ReservationTicket entity);


    /**
     * Find the next id
     */
    int nextId();

    /**
     * Delete a reservation ticket
     * @param entity the reservation ticket to be deleted
     */
    void delete(ReservationTicket entity);

    /**
     * Delete all reservation tickets
     */
    void deleteAll();

    /**
     * Find all reservation tickets
     */
    ArrayList<ReservationTicket> findAll();

    List<LocalTime[]> getEntryExitTimes(int parkingSpaceId);
}
