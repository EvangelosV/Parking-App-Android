package com.example.parkingspotmanager.view.Customer.CustomerPage;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.dao.CustomerDAO;
public class CustomerPagePresenter {

    private CustomerDAO customerDAO;
    private CustomerPageView view;
    private Customer customer;

    /**
     * Default constructor
     */
    public CustomerPagePresenter() {
    }

    /**
     * Method to find customer's username from the database
     * @param customerUsername
     */
    public Customer findCustomerInfo(String customerUsername) {
        if (customerUsername == null)
            return null;
        customer = customerDAO.find(customerUsername);
        return customer;
    }

    /**
     * Method to set the customer's database access object
     */
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Method to get the customer's username
     * @return customer's username
     */
    public String getCustomerUsername() {
        if (customer == null)
            return "";
        return customer.getUsername();
    }

    /**
     * Method to navigate to the search parking page
     */
    public void onSearchParkingSpace() {
        view.toSearchParking();
    }

    /**
     * Method to navigate to the show QR code page
     */
    public void onShowQRCode() {
        view.toShowQRCode();
    }

    /**
     * Method to navigate to the renewal page
     */
    public void onRenewal() {
        view.toRenewal();
    }

    /**
     * Method to navigate to the my reservations page
     */
    public void onMyReservations() {
        view.toMyReservations();
    }

    /**
     * Method to logout the customer
     */
    public void onLogout() {
        view.toLogout();
    }

    /**
     * Method to clear the view
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Method to set the view
     * @param view
     */
    public void setView(CustomerPageView view) {
        this.view = view;
    }

    /**
     * Method to get the view
     * @return view
     */
    public CustomerPageView getView() {
        return view;
    }

    /**
     * Method to get the customer's database access object
     * @return customer's database access object
     */
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

}
