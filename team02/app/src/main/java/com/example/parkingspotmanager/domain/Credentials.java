package com.example.parkingspotmanager.domain;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */


public class Credentials {

    private String Username;
    private String Password;


    /**
     * Constructor for user login
     * @param Username
     * @param Password
     */
    public Credentials(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    /**
     * Default constructor with empty parameters
     */
    public Credentials() {
    }


    /**
     * get the username of the credentials
     * @return
     */
    public String getUsername() {
        return this.Username;
    }

    /**
     * set the username of the credentials
     * @param Username
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * get the password of the credentials
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     * set the password of the credentials
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
