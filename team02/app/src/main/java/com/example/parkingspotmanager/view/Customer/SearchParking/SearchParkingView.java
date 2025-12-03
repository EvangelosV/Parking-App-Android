package com.example.parkingspotmanager.view.Customer.SearchParking;

import androidx.appcompat.app.AlertDialog;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import java.util.ArrayList;

public interface SearchParkingView {

    /**
     * show popup when customer selects a parking building
     * @param layoutId the layout of the popup
     * @param msg the message of the popup
     * @param btn1 the first button
     * @param btn2 the second button
     * @return
     */
    AlertDialog showPopup(int layoutId, String msg, int btn1, int btn2);

    /**
     * get the parking buildings that the customer can park in
     * @return the ArrayList of parking buildings
     */
    ArrayList<ParkingBuilding> getParkingBuildingList();

    /**
     * what happens when the homepage button is pressed
     */
    void backToHomePage();
}
