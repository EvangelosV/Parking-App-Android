package com.example.parkingspotmanager.domain;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class User {

    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Email;
    private final Credentials credentials;

    /**
     * Constructor for the User
     * @param FirstName for the user
     * @param LastName for the user
     * @param PhoneNumber for the user
     * @param Email for the user
     * @param Username for the user
     * @param Password for the user
     */
    public User(String FirstName, String LastName, String Email,String PhoneNumber ,String Username, String Password) {
        this.credentials = new Credentials(Username, Password);
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
    }

    /**
     * Getter for the first name
     * @return the first name
     */
    public String getFirstName() {
        return this.FirstName;
    }

    /**
     * Setter for the first name
     * @param FirstName the new first name
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * Getter for the last name
     * @return the last name
     */
    public String getLastName() {
        return this.LastName;
    }

    /**
     * Setter for the last name
     * @param LastName the new last name
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * Getter for the phone number
     * @return the phone number
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Setter for the phone number
     * @param PhoneNumber the new phone number
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * Getter for the email
     * @return the email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Setter for the email
     * @param Email the new email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Getter for the username
     * @return the username
     */
    public String getUsername() {
        return this.credentials.getUsername();
    }

    /**
     * Setter for the username
     * @param Username the new username
     */
    public void setUsername(String Username) {
        this.credentials.setUsername(Username);
    }

    /**
     * Getter for the password
     * @return the password
     */
    public String getPassword() {
        return this.credentials.getPassword();
    }

    /**
     * Setter for the password
     * @param Password the new password
     */
    public void setPassword(String Password) {
        this.credentials.setPassword(Password);
    }
}
