package com.example.parkingspotmanager.view.Customer.Reservations;

import com.example.parkingspotmanager.domain.Reservation;

import java.util.List;

public interface ReservationsView {
    List<Reservation> getReservationsList();
    void backToHomePage();
}
