package com.example.parkingspotmanager.view.Customer.Reservations;

import com.example.parkingspotmanager.domain.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationsViewStub implements ReservationsView {

    private List<Reservation> reservations = new ArrayList<>();

    private boolean onBackToHomePage = false;


    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsList() {
        return Collections.emptyList();
    }

    @Override
    public void backToHomePage() {
        onBackToHomePage = true;
    }




}