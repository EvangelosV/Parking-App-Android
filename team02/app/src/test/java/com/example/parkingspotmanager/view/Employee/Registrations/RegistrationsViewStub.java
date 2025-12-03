package com.example.parkingspotmanager.view.Employee.Registrations;

import androidx.appcompat.app.AlertDialog;

import com.example.parkingspotmanager.domain.Registration;

import java.util.ArrayList;

public class RegistrationsViewStub implements RegistrationsView {
    boolean onHomePage = false;
    @Override
    public AlertDialog showPopup(int layoutId, String msg, int btn1, int btn2) {
        return null;
    }

    @Override
    public ArrayList<Registration> getRegistrationsList() {
        return null;
    }

    @Override
    public void backToHomePage() {
        onHomePage = true;
    }

}