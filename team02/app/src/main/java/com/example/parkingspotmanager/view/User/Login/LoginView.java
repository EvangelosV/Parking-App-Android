package com.example.parkingspotmanager.view.User.Login;

public interface LoginView {

    /**
     * get the contents of the edit text
     * @return the username given
     */
    String getUsername();


    /**
     * get the contents of the edit text
     * @return the password given
     */
    String getPassword();


    /**
     * show a pop up message
     * @param view the view to show the pop up
     * @param msg the message to show
     */
    void showPopUp(LoginView view, String msg);


    /**
     * start the customer page
     * @param username the username of the customer
     */
    void startCustomerPage(String username);

    void startEmployeePage(String username);
    void startManagementPage(String username);
}
