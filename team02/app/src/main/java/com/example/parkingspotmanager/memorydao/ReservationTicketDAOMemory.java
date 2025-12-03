package com.example.parkingspotmanager.memorydao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.parkingspotmanager.dao.ReservationTicketDAO;
import com.example.parkingspotmanager.domain.ReservationTicket;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ReservationTicketDAOMemory implements ReservationTicketDAO {
    protected static List<ReservationTicket> entities = new ArrayList<ReservationTicket>();

    /**
     * Deletes all ReservationTicket entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }


    /**
     * Returns the next available ID for a ReservationTicket entity.
     *
     * @return The next available ID.
     */
    @Override
    public int nextId() {
        return 0;
    }

    /**
     * Deletes a ReservationTicket entity from the in-memory list.
     *
     * @param entity The ReservationTicket object to be deleted.
     */
    @Override
    public void delete(ReservationTicket entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all ReservationTicket entities stored in memory.
     *
     * @return The list of ReservationTicket entities.
     */
    @Override
    public ArrayList<ReservationTicket> findAll() {
        return new ArrayList<ReservationTicket>(entities);
    }

    /**
     * Saves a ReservationTicket entity to the in-memory list.
     *
     * @param entity The ReservationTicket object to be saved.
     */
    @Override
    public void save(ReservationTicket entity) {
        if (! entities.contains(entity))
            entities.add(entity);
    }

    @Override
    public List<LocalTime[]> getEntryExitTimes(int parkingSpaceId) {
        List<LocalTime[]> entryExitTimes = new ArrayList<>();
        for (ReservationTicket reservation : entities) {
            if (reservation.getReservation().getAssignedParkingSpace().getParkingSpaceId() == parkingSpaceId) {
                entryExitTimes.add(new LocalTime[]{reservation.getStartTime(), reservation.getExitTime()});
            }
        }
        return entryExitTimes;
    }
}
