package com.example.parkingspotmanager.domain;

import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class Employee extends User {

    private RegistrationDAOMemory registrationController = new RegistrationDAOMemory();

    /**
     * the full constructor
     * @param FirstName of the employee
     * @param LastName of the employee
     * @param email of the employee
     * @param phoneNumber of the employee
     * @param username of the employee
     * @param password of the employee
     */
    public Employee(String FirstName, String LastName,String email, String phoneNumber, String username, String password) {
        super(FirstName, LastName, email, phoneNumber, username, password);
    }

    /**
     * Method to approve a registration and generate a QR code for the customer and remove it from the pending list and add it to the approved list
     * @param registration the registration to be approved
     */
    public void approveRegistration(Registration registration) {
        registration.setStatus(Status.APPROVED);
        System.out.println("Registration for " + registration.getCustomer().getUsername() + " approved by " + this.getUsername());
        registrationController.findAllPending().remove(registration);
        registrationController.findAllApproved().add(registration);
    }

    /**
     * Method to reject a registration and remove it from the pending list
     * @param registration the registration to be rejected
     */
    public void rejectRegistration(Registration registration) {
        registration.setStatus(Status.REJECTED);
        System.out.println("Registration for " + registration.getCustomer().getUsername() + " rejected by " + this.getUsername());
        registrationController.findAllPending().remove(registration);
    }
}