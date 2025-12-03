package com.example.parkingspotmanager.view.Customer.CustomerPage;

public class CustomerPageViewStub implements CustomerPageView {

    boolean onRenewal = false, onLogout = false, onSearchParkingSpace = false, onShowQRCode = false;

    @Override
    public void toRenewal() {
        onRenewal = true;
    }

    @Override
    public void toLogout() {
        onLogout = true;
    }

    @Override
    public void toMyReservations() {

    }

    @Override
    public void toSearchParking() {
        onSearchParkingSpace = true;
    }

    @Override
    public void toShowQRCode() {
        onShowQRCode = true;
    }


}