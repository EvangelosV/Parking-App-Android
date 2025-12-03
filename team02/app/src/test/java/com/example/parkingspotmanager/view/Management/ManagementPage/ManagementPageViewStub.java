package com.example.parkingspotmanager.view.Management.ManagementPage;

public class ManagementPageViewStub implements ManagementPageView {
    boolean onAnalytics = false, onLogout = false;

    private String username= "UsernameTest";

    @Override
    public void toAnalytics() {
        onAnalytics = true;
    }

    @Override
    public void toLogout() {
        onLogout = true;
    }
}