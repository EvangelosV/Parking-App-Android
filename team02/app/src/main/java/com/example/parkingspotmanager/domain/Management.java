package com.example.parkingspotmanager.domain;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */

public class Management extends User{

    /**
     * the full constructor
     * @param FirstName of the management
     * @param LastName of the management
     * @param ManagementEmail of the management
     * @param ManagementPhoneNumber of the management
     * @param ManagementUsername of the management
     * @param ManagementPassword of the management
     */
    public Management(String FirstName,String LastName, String ManagementEmail, String ManagementPhoneNumber, String ManagementUsername, String ManagementPassword) {
        super(FirstName, LastName, ManagementEmail, ManagementPhoneNumber, ManagementUsername, ManagementPassword);
    }

}
