package com.example.parkingspotmanager.view.Customer.CustomerPage;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public interface CustomerPageView {
    /**
     * Navigates to the SearchParkingActivity to allow the customer to search for and book a parking spot.
     */
    void toSearchParking();

    /**
     * Navigates to the QRCodeActivity to display the customer's QR code.
     */
    void toShowQRCode();

    /**
     * Navigates to the RenewalActivity to allow the customer to renew their account balance.
     */
    void toRenewal();

    /**
     * Logs out the customer and navigates back to the HomePageActivity.
     */
    void toLogout();
    void toMyReservations();

}