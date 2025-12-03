package com.example.parkingspotmanager.view.HomePage;

/**
 * The HomePageView interface defines the contract for the view that handles the home page.
 * It provides methods for navigating to the login and registration pages.
 */
public interface HomePageView {

    /**
     * Navigates to the login page.
     */
    void loginAction();

    /**
     * Navigates to the registration page.
     */
    void registerAction();
}