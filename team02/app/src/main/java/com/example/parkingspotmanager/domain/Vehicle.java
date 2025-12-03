package com.example.parkingspotmanager.domain;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class Vehicle {
    private String licensePlate;
    private String brand;
    private String model;

    /**
     * Constructor for the Vehicle
     * @param licensePlate for the vehicle
     * @param brand for the vehicle
     * @param model for the vehicle
     */
    public Vehicle(String licensePlate, String brand, String model) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
    }

    /**
     * Getter for the license plate
     * @return the license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Setter for the license plate
     * @param licensePlate the new license plate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Getter for the brand
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for the brand
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for the model
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for the model
     * @param model the new model
     */
    public void setModel(String model) {
        this.model = model;
    }
}
