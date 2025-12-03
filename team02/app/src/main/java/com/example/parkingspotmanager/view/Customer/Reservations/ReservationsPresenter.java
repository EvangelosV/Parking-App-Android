package com.example.parkingspotmanager.view.Customer.Reservations;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.ReservationTicket;
import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.dao.ReservationDAO;
import com.example.parkingspotmanager.dao.ReservationTicketDAO;
import com.example.parkingspotmanager.view.Customer.CustomerPage.CustomerPageActivity;

import java.util.ArrayList;
import java.util.List;

public class ReservationsPresenter {
    private ReservationDAO reservationDAO;
    private CustomerDAO customerDAO;
    private Customer customer;
    private ReservationTicketDAO reservationTicketDAO;
    private ReservationsView view;
    private Reservation reservation;
    private ReservationTicket reservationTicket;

    public ReservationsPresenter (){}

    public void setView(ReservationsView view) {
        this.view = view;
    }

    public ReservationsView getView(){return view;}

    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public ReservationDAO getReservationDAO() {
        return reservationDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setReservationTicketDAO(ReservationTicketDAO reservationTicketDAO) {
        this.reservationTicketDAO = reservationTicketDAO;
    }

    public ReservationTicket getReservationTicketDAO() {
        return reservationTicket;
    }

    public void clearView() {
        view = null;
    }

    public Customer findCustomerInfo(String customerUsername) {
        if (customerUsername == null)
            return null;
        customer = customerDAO.find(customerUsername);
        return customer;
    }

    public void onHomePage() {
        view.backToHomePage();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Reservation> getReservationsList() {
        return reservationDAO.findAll();
    }
}
