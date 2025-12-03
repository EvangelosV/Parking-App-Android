package com.example.parkingspotmanager.view.Customer.SearchParking;

import androidx.appcompat.app.AlertDialog;

import com.example.parkingspotmanager.domain.ParkingBuilding;

import java.util.ArrayList;

public class SearchParkingViewStub implements SearchParkingView {

    boolean backToHomePageCalled = false;

    @Override
    public AlertDialog showPopup(int layoutId, String msg, int btn1, int btn2) {
        return null;
    }

    @Override
    public ArrayList<ParkingBuilding> getParkingBuildingList() {
        return null;
    }

    @Override
    public void backToHomePage() {
        backToHomePageCalled = true;
    }
}