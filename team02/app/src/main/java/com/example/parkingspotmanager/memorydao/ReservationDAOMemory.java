package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.ReservationDAO;
import com.example.parkingspotmanager.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ReservationDAOMemory implements ReservationDAO{
    protected static ArrayList<Reservation> entities = new ArrayList<Reservation>();

    /**
     * Deletes all Reservation entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Saves a Reservation entity to the in-memory list.
     *
     * @param entity The Reservation object to be saved.
     */
    @Override
    public void save(Reservation entity) {
        entities.add(entity);
    }

    /**
     * Returns a list of all Reservation entities stored in memory.
     *
     * @return The list of Reservation entities.
     */
    @Override
    public List<Reservation> findAll() {
        return new ArrayList<Reservation>(entities);
    }


    /**
     * Deletes a Reservation entity from the in-memory list.
     * @param entity the reservation to be deleted
     */
    @Override
    public void delete(Reservation entity) {
        entities.remove(entity);
    }

    /**
     *Finds reservations based on the parking space id
     * @return a list of reservations
     */
    public List<Reservation> findReservationsByParkingSpaceId(int parkingSpaceId) {
        List<Reservation> reservations = new ArrayList<Reservation>();
        for(Reservation reservation : entities)
            if(reservation.getAssignedParkingSpace().getParkingSpaceId() == parkingSpaceId)
                reservations.add(reservation);
        return reservations;
    }

    /**
     * Finds reservations based on the username
     * @return a list of reservations
     */
    public List<Reservation> findReservationsByUsername(String username) {
        List<Reservation> reservations = new ArrayList<Reservation>();
        for(Reservation reservation : entities)
            if(reservation.getCustomer().getUsername().equals(username))
                reservations.add(reservation);

        return reservations;
    }

    /**
     * Finds reservations based on the building id
     * @return a list of reservations
     */
    public List<Reservation> findReservationsByBuildingId(int buildingId) {
        List<Reservation> reservations = new ArrayList<Reservation>();
        for(Reservation reservation : entities)
            if(reservation.getAssignedParkingSpace().getParkingBuilding().getBuildingId() == buildingId)
                reservations.add(reservation);
        return reservations;
    }
}
