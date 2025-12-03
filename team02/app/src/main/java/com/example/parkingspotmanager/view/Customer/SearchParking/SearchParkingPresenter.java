package com.example.parkingspotmanager.view.Customer.SearchParking;

import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.dao.ParkingBuildingDAO;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.memorydao.ParkingBuildingDAOMemory;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The SearchParkingPresenter class handles the business logic for searching and booking parking spaces.
 * It interacts with the SearchParkingView interface to update the UI and uses the CustomerDAO and ParkingBuildingDAO
 * to manage customer and parking building data.
 */
public class SearchParkingPresenter {
    private SearchParkingView view;
    private CustomerDAO customerDAO;
    private Customer customer;
    private ParkingBuildingDAO parkingBuildingDAO;

    /**
     * Default constructor for SearchParkingPresenter.
     */
    public SearchParkingPresenter() {
    }

    /**
     * Retrieves customer information based on the provided username.
     *
     * @param customerUsername The username of the customer to find.
     */
    public void findCustomerInfo(String customerUsername) {
        if (customerUsername == null)
            return;
        customer = customerDAO.find(customerUsername);
    }

    /**
     * Sets the view interface for this presenter.
     *
     * @param view The SearchParkingView interface implementation.
     */
    public void setView(SearchParkingView view) {
        this.view = view;
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Sets the CustomerDAO instance to be used by the presenter.
     *
     * @param customerDAO The CustomerDAO instance.
     */
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Sets the ParkingBuildingDAO instance to be used by the presenter.
     *
     * @param parkingBuildingDAO The ParkingBuildingDAO instance.
     */
    public void setParkingBuildingDAO(ParkingBuildingDAO parkingBuildingDAO) {
        this.parkingBuildingDAO = parkingBuildingDAO;
    }

    /**
     * Returns the list of all parking buildings.
     *
     * @return An ArrayList containing all ParkingBuilding objects.
     */
    public ArrayList<ParkingBuilding> getParkingBuildings() {
        return parkingBuildingDAO.findAll();
    }

    /**
     * Attempts to book a parking space in the specified parking building for the given time interval.
     *
     * @param parkingBuilding The parking building where the spot is to be booked.
     * @param entryTime       The entry time for the reservation.
     * @param exitTime        The exit time for the reservation.
     * @return true if the booking is successful, false otherwise.
     */
    public boolean BookSpace(ParkingBuilding parkingBuilding, LocalTime entryTime, LocalTime exitTime) {
        return customer.bookParkingSpot(parkingBuilding, entryTime, exitTime);
    }

    /**
     * Navigates back to the customer's home page.
     */
    public void onHomePage() {
        view.backToHomePage();
    }

    /**
     * Returns the CustomerDAO instance used by the presenter.
     *
     * @return The CustomerDAO instance.
     */
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    /**
     * Returns the current customer object.
     *
     * @return The Customer object.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Returns the ParkingBuildingDAO instance used by the presenter.
     *
     * @return The ParkingBuildingDAO instance.
     */
    public ParkingBuildingDAO getParkingBuildingDAO() {
        return parkingBuildingDAO;
    }

    /**
     * Returns the current view interface.
     *
     * @return The SearchParkingView interface implementation.
     */
    public Object getView() {
        return view;
    }

    /**
     * Searches for parking buildings by zip code.
     *
     * @param zipCode The zip code to search for.
     * @return An ArrayList of ParkingBuilding objects that match the zip code.
     */
    public ArrayList<ParkingBuilding> onSearchParkingBuilding(String zipCode) {
        return ((ParkingBuildingDAOMemory) parkingBuildingDAO).findByZipCode(zipCode);
    }
}