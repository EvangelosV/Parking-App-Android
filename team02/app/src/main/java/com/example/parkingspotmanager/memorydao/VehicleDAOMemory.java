package com.example.parkingspotmanager.memorydao;

import java.util.ArrayList;
import java.util.List;

import com.example.parkingspotmanager.dao.VehicleDAO;
import com.example.parkingspotmanager.domain.Vehicle;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class VehicleDAOMemory implements VehicleDAO {
    protected static List<Vehicle> entities = new ArrayList<Vehicle>();

    /**
     * Deletes all Vehicle entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }



    /**
     * Deletes a Vehicle entity from the in-memory list.
     *
     * @param entity The Vehicle object to be deleted.
     */
    @Override
    public void delete(Vehicle entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all Vehicle entities stored in memory.
     *
     * @return The list of Vehicle entities.
     */
    public ArrayList<Vehicle> findAll() {
        return new ArrayList<Vehicle>(entities);
    }

    /**
     * Saves a Vehicle entity to the in-memory list.
     *
     * @param entity The Vehicle object to be saved.
     */
    @Override
    public void save(Vehicle entity) {
        if (! entities.contains(entity))
            entities.add(entity);
    }
}
