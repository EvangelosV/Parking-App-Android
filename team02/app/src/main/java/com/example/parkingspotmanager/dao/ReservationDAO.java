package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Reservation;

import java.util.List;


/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface ReservationDAO {

    /**
     * Save a reservation
     * @param entity the reservation to be saved
     */
    void save(Reservation entity);


    /**
     * Delete a reservation
     * @param entity the reservation to be deleted
     */
    void delete(Reservation entity);

    /**
     * Delete all reservations
     */
    void deleteAll();

    /**
     * Find all reservations
     * @return a list of all reservations
     */
    List<Reservation> findAll();
}
