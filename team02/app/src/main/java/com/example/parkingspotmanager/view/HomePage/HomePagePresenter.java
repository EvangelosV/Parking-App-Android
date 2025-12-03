package com.example.parkingspotmanager.view.HomePage;

/**
 * The HomePagePresenter class handles the business logic for the home page.
 * It interacts with the HomePageView interface to update the UI.
 */
public class HomePagePresenter {
    private HomePageView view;

    /**
     * Default constructor for HomePagePresenter.
     */
    public HomePagePresenter() {
    }

    /**
     * Handles the login action.
     */
    public void onLoginAction() {
        view.loginAction();
    }

    /**
     * Handles the register action.
     */
    public void onRegisterAction() {
        view.registerAction();
    }

    /**
     * Sets the view interface for this presenter.
     *
     * @param view The HomePageView interface implementation.
     */
    public void setView(HomePageView view) {
        this.view = view;
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
    }
}