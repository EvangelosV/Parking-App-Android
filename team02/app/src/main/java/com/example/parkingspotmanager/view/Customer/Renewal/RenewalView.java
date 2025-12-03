package com.example.parkingspotmanager.view.Customer.Renewal;

import android.app.AlertDialog;

/**
 * The RenewalView interface defines the contract for the view that handles customer account balance renewal.
 * It provides methods for retrieving the deposit amount, updating the balance, and displaying popups.
 */
public interface RenewalView {

    /**
     * Retrieves the deposit amount entered by the customer.
     *
     * @return The deposit amount as a double.
     */
    double getDeposit();

    /**
     * Updates the displayed account balance.
     *
     * @param balance The new account balance to display.
     */
    void updateBalance(double balance);

    /**
     * Displays a popup with a specific layout and message.
     *
     * @param layout The layout resource for the popup.
     * @param msg    The message to display in the popup.
     * @param btn1   The resource ID for the first button.
     * @param btn2   The resource ID for the second button.
     */
    void displayPopUpAction(int layout, String msg, int btn1, int btn2);

    /**
     * Displays a popup with a custom layout and message.
     *
     * @param layout The RenewalView interface implementation.
     * @param msg    The message to display in the popup.
     */
    void showPopUp(RenewalView layout, String msg);
}