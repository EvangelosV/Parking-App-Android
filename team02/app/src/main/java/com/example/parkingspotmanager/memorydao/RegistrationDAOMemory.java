package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.RegistrationDAO;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.domain.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class RegistrationDAOMemory implements RegistrationDAO {
    protected static ArrayList<Registration> entities = new ArrayList<Registration>();

    /**
     * Deletes all Registration entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Saves a Registration entity to the in-memory list.
     *
     * @param entity The Registration object to be saved.
     */
    @Override
    public void save(Registration entity) {
        entities.add(entity);
    }

    /**
     * Find based username
     *
     * @param username
     */
    @Override
    public Registration findByUsername(String username) {
        for (Registration registration : entities) {
            if (registration.getCustomer().getUsername().equals(username)) {
                return registration;
            }
        }
        return null;
    }

    /**
     * Returns a list of all Registration entities stored in memory.
     *
     * @return The list of Registration entities.
     */
    public List<Registration> findAll() {
        return new ArrayList<Registration>(entities);
    }


    /**
     * Deletes a Registration entity from the in-memory list.
     *
     * @param entity The Registration object to be deleted.
     */
    @Override
    public void delete(Registration entity) {
        entities.remove(entity);
    }


    /**
     * Finds all pending registrations
     * @return a list of all pending registrations
     */
    public ArrayList<Registration> findAllPending() {
        ArrayList<Registration> pendingRegistrations = new ArrayList<Registration>();
        for(Registration registration : entities)
            if(registration.getStatus() == Status.PENDING){
                pendingRegistrations.add(registration);
            }
        return pendingRegistrations;
    }

    /**
     * Finds all approved registrations
     * @return a list of all approved registrations
     */
    public ArrayList<Registration> findAllApproved() {
        ArrayList<Registration> approvedRegistrations = new ArrayList<Registration>();
        for(Registration registration : entities)
            if(registration.getStatus() == Status.APPROVED){
                approvedRegistrations.add(registration);
            }
        return approvedRegistrations;
    }
}
