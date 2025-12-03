package com.example.parkingspotmanager.view.Management.ManagementPage;

import com.example.parkingspotmanager.dao.ManagementDAO;
import com.example.parkingspotmanager.domain.Management;

/**
 * The `ManagementPagePresenter` class acts as the intermediary between the `ManagementPageView` and the data layer.
 * It handles business logic related to fetching management information, logging out, and navigating to analytics.
 */
public class ManagementPagePresenter {

    private ManagementDAO managementDAO;
    private ManagementPageView view;
    private Management management;

    /**
     * Default constructor for the `ManagementPagePresenter`.
     */
    public ManagementPagePresenter() {
    }

    /**
     * Sets the `ManagementDAO` instance to be used for data access operations.
     *
     * @param managementDAO The `ManagementDAO` instance to be set.
     */
    public void setManagementDAO(ManagementDAO managementDAO) {
        this.managementDAO = managementDAO;
    }

    /**
     * Retrieves management information for the specified username.
     *
     * @param Username The username of the management user.
     * @return The `Management` object containing the user's information, or `null` if the username is invalid.
     */
    public Management getManagementInfo(String Username) {
        if (Username == null)
            return null;
        management = managementDAO.find(Username);
        return management;
    }

    /**
     * Retrieves the username of the currently logged-in management user.
     *
     * @return The username as a `String`, or an empty string if no management user is set.
     */
    public String getManagementUsername() {
        if (management == null)
            return "";
        return management.getUsername();
    }

    /**
     * Handles the action when the analytics button is clicked.
     * Delegates the navigation to the `ManagementPageView`.
     */
    public void onAnalytics() {
        view.toAnalytics();
    }

    /**
     * Handles the action when the logout button is clicked.
     * Delegates the logout process to the `ManagementPageView`.
     */
    public void onLogout() {
        view.toLogout();
    }

    /**
     * Clears the reference to the `ManagementPageView` to avoid memory leaks.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Sets the `ManagementPageView` instance to be used for updating the UI.
     *
     * @param view The `ManagementPageView` instance to be set.
     */
    public void setView(ManagementPageView view) {
        this.view = view;
    }

    /**
     * Retrieves the current `ManagementPageView` instance.
     *
     * @return The `ManagementPageView` instance, or `null` if not set.
     */
    public Object getView() {
        return view;
    }

    /**
     * Retrieves the `ManagementDAO` instance used for data access operations.
     *
     * @return The `ManagementDAO` instance.
     */
    public ManagementDAO getManagementDAO() {
        return managementDAO;
    }
}