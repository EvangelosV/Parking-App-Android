package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.ParkingTicketDAO;
import com.example.parkingspotmanager.domain.ParkingTicket;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ParkingTicketDAOMemory implements ParkingTicketDAO {
    protected static ArrayList<ParkingTicket> entities = new ArrayList<ParkingTicket>();

    /**
     * Deletes all ParkingTicket entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Deletes a ParkingTicket entity from the in-memory list.
     * @param entity the parking ticket to be deleted
     */
    @Override
    public void delete(ParkingTicket entity) {
        entities.remove(entity);
    }

    /**
     * Generates the next available ID for a ParkingTicket entity.
     * @return the next available ID
     */
    @Override
    public int nextId() {
        return (!entities.isEmpty() ? entities.get(entities.size() - 1).getParkingTicketID() + 1 : 1);
    }

    /**
     * Returns a list of all ParkingTicket entities stored in memory.
     * @return the list of parking tickets
     */
    @Override
    public ArrayList<ParkingTicket> findAll() {
        return new ArrayList<ParkingTicket>(entities);
    }

    /**
     * Saves a ParkingTicket entity to the in-memory list.
     * @param entity the parking ticket to be saved
     */
    @Override
    public void save(ParkingTicket entity) {
        entities.add(entity);
    }

    /**
     * Finds a ParkingTicket by its ID.
     * @param ticketId the ID of the parking ticket
     * @return the parking ticket
     */
    @Override
    public ParkingTicket find(int ticketId)
    {
        for(ParkingTicket ticket : entities)
            if(ticket.getParkingTicketID() == ticketId)
                return ticket;

        return null;
    }
}
