package com.example.parkingspotmanager.view.Employee.EmployeePage;

public class EmployeePageViewStub implements EmployeePageView {

    boolean toLogoutCalled = false;
    boolean toRegistrationsCalled = false;

    @Override
    public void toLogout() {
        toLogoutCalled = true;
    }

    @Override
    public void toRegistrations() {
        toRegistrationsCalled = true;
    }
}