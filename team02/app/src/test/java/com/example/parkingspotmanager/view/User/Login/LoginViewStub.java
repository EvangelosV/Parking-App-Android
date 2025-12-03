package com.example.parkingspotmanager.view.User.Login;


public class LoginViewStub implements LoginView {
    private String username= "UsernameTest";
    private String password= "PasswordTest";


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void showPopUp(LoginView view, String msg) {

    }


    @Override
    public void startCustomerPage(String username) {

    }

    @Override
    public void startEmployeePage(String username) {

    }

    @Override
    public void startManagementPage(String username) {

    }

}
