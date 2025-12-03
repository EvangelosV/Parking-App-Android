package com.example.parkingspotmanager.view.User.Register;

public class RegisterViewStub implements RegisterView {
    String username, password, email, name, surname, phone, licensePlate, brand, model;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String surname) {
        this.surname = surname;
    }

    @Override
    public String getPhoneNumber() {
        return phone;
    }

    @Override
    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void showPopUp(RegisterView view, String msg) {

    }

    @Override
    public void startHomePageActivity() {

    }



}
