package com.example.parkingspotmanager.view.Customer.Renewal;

import android.app.AlertDialog;

public class RenewalViewStub implements RenewalView {

    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {
    }

    @Override
    public void showPopUp(RenewalView layout, String msg) {
        return ;
    }
    @Override
    public double getDeposit() {
        return 0;
    }

    @Override
    public void updateBalance(double balance) {
    }

   }