package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.ParkingBuildingDAO;
import com.example.parkingspotmanager.domain.ParkingBuilding;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ParkingBuildingDAOMemory implements ParkingBuildingDAO {
    protected static ArrayList<ParkingBuilding> entities = new ArrayList<ParkingBuilding>();

    /**
     * Deletes all ParkingBuilding entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Saves a ParkingBuilding entity to the in-memory list.
     *
     * @param entity The ParkingBuilding object to be saved.
     */
    @Override
    public void save(ParkingBuilding entity) {
        entities.add(entity);
    }

    /**
     * Generates the next available ID for a ParkingBuilding entity.
     *
     * @return The next available ID (incremented by 1 from the last entity's ID).
     */
    @Override
    public int nextId() {
        return (!entities.isEmpty() ? entities.get(entities.size() - 1).getBuildingId() + 1 : 1);
    }

    /**
     * Finds a ParkingBuilding by its ID.
     *
     * @param parkingBuildingID The ID of the ParkingBuilding to find.
     * @return The ParkingBuilding object if found, otherwise null.
     */
    @Override
    public ParkingBuilding find(int parkingBuildingID) {
        for (ParkingBuilding parkingBuilding : entities) {
            if (parkingBuilding.getBuildingId() == parkingBuildingID) {
                return parkingBuilding;
            }
        }
        return null;
    }

    /**
     * Finds all ParkingBuilding entities that match a specific zip code.
     *
     * @param zipCode The zip code to search for.
     * @return A list of ParkingBuilding objects that match the zip code.
     */
    public ArrayList<ParkingBuilding> findByZipCode(String zipCode) {
        ArrayList<ParkingBuilding> buildingsByZip = new ArrayList<>();
        for (ParkingBuilding parkingBuilding : entities) {
            if (parkingBuilding.getPostalCode().equals(zipCode)) {
                buildingsByZip.add(parkingBuilding);
            }
        }
        return buildingsByZip;
    }

    /**
     * Deletes a ParkingBuilding entity from the in-memory list.
     *
     * @param entity The ParkingBuilding object to be deleted.
     */
    @Override
    public void delete(ParkingBuilding entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all ParkingBuilding entities stored in memory.
     *
     * @return An ArrayList containing all ParkingBuilding objects.
     */
    @Override
    public ArrayList<ParkingBuilding> findAll() {
        return new ArrayList<ParkingBuilding>(entities);
    }
}
