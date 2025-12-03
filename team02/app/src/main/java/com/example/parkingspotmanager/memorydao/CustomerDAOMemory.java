package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.domain.Credentials;
import com.example.parkingspotmanager.domain.Customer;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class CustomerDAOMemory implements CustomerDAO {
    protected static ArrayList<Customer> entities = new ArrayList<Customer>();

    /**
     * Saves a Customer entity to the in-memory list.
     *
     * @param entity The Customer object to be saved.
     */
    @Override
    public void save(Customer entity) {
        entities.add(entity);
    }

    /**
     * Finds a Customer by their username.
     *
     * @param customerUsername The username of the Customer to find.
     * @return The Customer object if found, otherwise null.
     */
    @Override
    public Customer find(String customerUsername) {
        for (Customer customer : entities) {
            if (customer.getUsername().equals(customerUsername)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Finds a Customer by their credentials (username and password).
     *
     * @param credentials The credentials (username and password) to search for.
     * @return The Customer object if found, otherwise null.
     */
    @Override
    public Customer findByCredentials(Credentials credentials) {
        for (Customer customer : entities) {
            if (customer.getUsername().equals(credentials.getUsername()) &&
                    customer.getPassword().equals(credentials.getPassword())) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Deletes a Customer entity from the in-memory list.
     *
     * @param entity The Customer object to be deleted.
     */
    @Override
    public void delete(Customer entity) {
        entities.remove(entity);
    }

    /**
     * Deletes all Customer entities from the in-memory list.
     */
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Returns a list of all Customer entities stored in memory.
     *
     * @return An ArrayList containing all Customer objects.
     */
    @Override
    public ArrayList<Customer> findAll() {
        return new ArrayList<Customer>(entities);
    }

    /**
     * Finds a Customer by their email address.
     *
     * @param email The email address of the Customer to find.
     * @return The Customer object if found, otherwise null.
     */
    @Override
    public Customer findByEmail(String email) {
        for (Customer customer : entities) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Finds a Customer by their phone number.
     *
     * @param phoneNumber The phone number of the Customer to find.
     * @return The Customer object if found, otherwise null.
     */
    @Override
    public Customer findByPhone(String phoneNumber) {
        for (Customer customer : entities) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }
}
