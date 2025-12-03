package com.example.parkingspotmanager.memorydao;


import com.example.parkingspotmanager.dao.ParkingSpaceDAO;
import com.example.parkingspotmanager.domain.ParkingSpace;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ParkingSpaceDAOMemory implements ParkingSpaceDAO {
    protected static ArrayList<ParkingSpace> entities = new ArrayList<ParkingSpace>();

    /**
     * Deletes all ParkingSpace entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
    }

    /**
     * Deletes a ParkingSpace entity from the in-memory list.
     *
     * @param entity The ParkingSpace object to be deleted.
     */
    @Override
    public void delete(ParkingSpace entity) {
        entities.remove(entity);
    }

    /**
     * Returns a list of all ParkingSpace entities stored in memory.
     *
     * @return The list of ParkingSpace entities.
     */
    @Override
    public ArrayList<ParkingSpace> findAll() {
        return new ArrayList<ParkingSpace>(entities);
    }

    /**
     * Saves a ParkingSpace entity to the in-memory list.
     *
     * @param entity The ParkingSpace object to be saved.
     */
    @Override
    public void save(ParkingSpace entity) {
        entities.add(entity);
    }

    /**
     * Finds a ParkingSpace by its ID.
     *
     * @param spaceId The ID of the ParkingSpace to find.
     * @return The ParkingSpace object if found, otherwise null.
     */
    @Override
    public ParkingSpace find(int spaceId) {
        for (ParkingSpace space : entities)
            if (space.getParkingSpaceId() == spaceId)
                return space;

        return null;
    }

    /**
     * Finds all ParkingSpace entities that match a specific building ID.
     *
     * @param buildingId The building ID to search for.
     * @return A list of ParkingSpace objects that match the building ID.
     */
    @Override
    public ArrayList<ParkingSpace> findParkingSpacesByBuildingId(int buildingId) {
        ArrayList<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
        for (ParkingSpace space : entities)
            if (space.getParkingBuilding().getBuildingId() == buildingId)
                parkingSpaces.add(space);
        return parkingSpaces;
    }
}
