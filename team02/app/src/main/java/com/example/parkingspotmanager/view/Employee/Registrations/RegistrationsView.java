package com.example.parkingspotmanager.view.Employee.Registrations;

import androidx.appcompat.app.AlertDialog;
import com.example.parkingspotmanager.domain.Registration;
import java.util.ArrayList;

public interface RegistrationsView {

    /** show popup when employee selects a registration
     * @param layoutId the layout of the popup
     * @param msg the message of the popup
     * @param btn1 the first button
     * @param btn2 the second button
     * @return
     */
    AlertDialog showPopup(int layoutId, String msg, int btn1, int btn2);

    /**
     * get the registrations that the employee has received
     * @return the ArrayList of registrations
     */
    ArrayList<Registration> getRegistrationsList();

    /**
     * what happens when the homepage button is pressed
     */
    void backToHomePage();
}
