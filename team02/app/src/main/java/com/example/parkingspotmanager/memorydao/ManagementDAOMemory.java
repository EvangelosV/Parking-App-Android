package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.ManagementDAO;
import com.example.parkingspotmanager.domain.Management;
import java.util.ArrayList;

import com.example.parkingspotmanager.domain.Credentials;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ManagementDAOMemory implements ManagementDAO {
    protected static ArrayList<Management> entities = new ArrayList<Management>();

    /**
     * Deletes all Management entities from the in-memory list.
     */
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Find a management by username
     * @param username the username of the management
     * @return the management account
     */
    @Override
    public Management find(String username) {
        for (Management management : entities) {
            if (management.getUsername().equals(username)) {
                return management;
            }
        }
        return null;
    }

    /**
     * Saves a Management entity to the in-memory list.
     *
     * @param entity The Management object to be saved.
     */
    @Override
    public void save(Management entity) {
        entities.add(entity);
    }

    /**
     * Deletes a Management entity from the in-memory list.
     *
     * @param entity The Management object to be deleted.
     */
    @Override
    public void delete(Management entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all Management entities stored in memory.
     *
     * @return The list of Management objects.
     */
    @Override
    public ArrayList<Management> findAll() {
        return new ArrayList<Management>(entities);
    }

    /**
     * Finds a Management by their credentials (username and password).
     *
     * @param credentials The credentials (username and password) to search for.
     * @return The Management object if found, otherwise null.
     */
    @Override
    public Management findByCredentials(Credentials credentials) {
        for (Management management : entities) {
            if(management.getUsername().equals(credentials.getUsername()) && management.getPassword().equals(credentials.getPassword())) {
                return management;
            }
        }
        return null;
    }
}
