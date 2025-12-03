package com.example.parkingspotmanager.domain;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class ParkingBuilding {

    private int buildingId;// Building ID
    private String buildingAddress;// Building Address
    private String openingHours;// Opening Hours
    private String closingHours;// Closing Hours
    private String postalCode;// Postal Code
    private int availableSpaces;// Available Spaces


    /**
     * Constructor for the Parking Building
     * @param buildingId for the building
     * @param buildingAddress for the building
     * @param openingHours for the building
     * @param closingHours for the building
     * @param postalCode for the building
     */
    public ParkingBuilding(int buildingId, String buildingAddress, String openingHours, String closingHours, String postalCode) {
        this.buildingId = buildingId;
        this.buildingAddress = buildingAddress;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.postalCode = postalCode;
        this.availableSpaces = 0;
    }

    /**
     * get the available spaces
     * @return the available spaces
     */
    public int getAvailableSpaces() {
        return availableSpaces;
    }

    /**
     * set the available spaces
     * @param availableSpaces the new available spaces
     */
    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    /**
     * increase the available spaces by 1
     */
    public void increaseSpaces() {
        availableSpaces++;
    }

    /**
     * decrease the available spaces by 1
     */
    public void decreaseSpaces() {
        availableSpaces--;
    }

    /**
     * get the building id
     * @return the building id
     */
    public int getBuildingId() {
        return buildingId;
    }

    /**
     * set the building id
     * @param buildingId the new building id
     */
    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * get the building address
     * @return the building address
     */
    public String getBuildingAddress() {
        return buildingAddress;
    }

    /**
     * set the building address
     * @param buildingAddress the new building address
     */
    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    /**
     * get the opening hours
     * @return the opening hours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * set the opening hours
     * @param openingHours the new opening hours
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * get the closing hours
     * @return the closing hours
     */
    public String getClosingHours() {
        return closingHours;
    }

    /**
     * set the closing hours
     * @param closingHours the new closing hours
     */
    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    /**
     * get the postal code
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * set the postal code
     * @param postalCode the new postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    /**
     * get the building id
     * @return the building id
     */
    public int getId() {
        return buildingId;
    }

    /**
     * get the address of the building
     * @return the address of the building
     */
    public String getAddress() {
        return buildingAddress;
    }

}
