package com.example.parkingspotmanager.view.Customer.QRCode;

import android.graphics.Bitmap;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.dao.CustomerDAO;

/**
 * The QRCodePresenter class handles the business logic for generating and managing QR codes
 * for customers. It interacts with the QRCodeView interface to update the UI and uses the
 * CustomerDAO to retrieve customer information.
 */
public class QRCodePresenter {
    private QRCodeView view;
    private CustomerDAO customerDAO;
    private Customer customer;

    /**
     * Default constructor for QRCodePresenter.
     */
    public QRCodePresenter() {
    }

    /**
     * Generates a QR code for the given customer and saves it to the file system.
     * The QR code is then loaded and displayed in the view.
     *
     * @param customer The customer object containing the data to be encoded in the QR code.
     * @param username The username used to name the saved QR code file.
     */
    public void createQRCode(Customer customer, String username) {
        // Generate the QR code and save it to the file system
        view.generateQRCode(customer, username, 500, 500);

        // Load the QR code from the file system and display it
        String fileName = username + ".png";
        Bitmap qrCodeBitmap = view.getQRCode(fileName);

        if (qrCodeBitmap != null) {
            view.setQRCode(qrCodeBitmap);
        }
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
     * Retrieves customer information based on the provided username.
     *
     * @param customerUsername The username of the customer to find.
     * @return The Customer object if found, otherwise null.
     */
    public Customer findCustomerInfo(String customerUsername) {
        if (customerUsername == null)
            return null;
        customer = customerDAO.find(customerUsername);
        return customer;
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
     * Sets the view interface for this presenter.
     *
     * @param view The QRCodeView interface implementation.
     */
    public void setView(QRCodeView view) {
        this.view = view;
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Returns the current view interface.
     *
     * @return The QRCodeView interface implementation.
     */
    public Object getView() {
        return view;
    }

    /**
     * Returns the CustomerDAO instance used by the presenter.
     *
     * @return The CustomerDAO instance.
     */
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }
}