package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.RenewalDAO;
import com.example.parkingspotmanager.domain.Renewal;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class RenewalDAOMemory implements RenewalDAO {
    protected static ArrayList<Renewal> entities = new ArrayList<Renewal>();

    /**
     * Deletes all Renewal entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Saves a Renewal entity to the in-memory list.
     *
     * @param entity The Renewal object to be saved.
     */
    @Override
    public void save(Renewal entity) {
        entities.add(entity);
    }

    /**
     * Returns a list of all Renewal entities stored in memory.
     * @return The list of Renewal entities.
     */
    @Override
    public ArrayList<Renewal> findAll() {
        return new ArrayList<Renewal>(entities);
    }



    /**
     * Deletes a Renewal entity from the in-memory list.
     *
     * @param entity The Renewal object to be deleted.
     */
    @Override
    public void delete(Renewal entity) {
        entities.remove(entity);
    }

    /**
     * Returns the next available ID for a Renewal entity.
     *
     * @return The next available ID.
     */
    @Override
    public int nextId() {
        return 1;
    }
}
