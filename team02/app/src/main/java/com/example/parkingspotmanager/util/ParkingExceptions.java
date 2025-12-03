package com.example.parkingspotmanager.util;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class ParkingExceptions extends RuntimeException {

    /**
     * Constructs a new ParkingExceptions with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ParkingExceptions(String message) {
        super(message);
    }

    /**
     * Constructs a new ParkingExceptions with no detail message.
     */
    public ParkingExceptions() {
        super();
    }
}
