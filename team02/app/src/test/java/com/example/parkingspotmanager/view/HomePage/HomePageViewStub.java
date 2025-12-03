package com.example.parkingspotmanager.view.HomePage;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class HomePageViewStub implements HomePageView {
    boolean onLogin = false, onRegister = false;

    @Override
    public void loginAction() {
        onLogin = true;

    }

    @Override
    public void registerAction() {
        onRegister = true;

    }

}
