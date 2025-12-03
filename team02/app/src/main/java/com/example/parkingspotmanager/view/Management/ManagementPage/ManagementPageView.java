package com.example.parkingspotmanager.view.Management.ManagementPage;

/**
 * The `ManagementPageView` interface defines the contract for the view in the Management Page feature.
 * It specifies the methods that must be implemented by any class acting as the view for the Management Page.
 */
public interface ManagementPageView {

    /**
     * Handles the logout action. Displays a toast message and navigates the user back to the home page.
     */
    void toLogout();

    /**
     * Handles the navigation to the analytics section. This method should navigate the user
     * to a screen or fragment where analytics data is displayed.
     */
    void toAnalytics();
}