package com.example.parkingspotmanager.view.Analytics.AvgDuration;

import androidx.appcompat.app.AlertDialog;

import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;

import java.util.ArrayList;

public interface AvgDurationView {
    AlertDialog showPopup(int layoutId, String msg);

    ArrayList<ParkingSpace> getParkingSpaceList();

    void backToHomePage();
}
