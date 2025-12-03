package com.example.parkingspotmanager.view.User.Login;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;

public class LoginViewModel extends ViewModel {
    LoginPresenter presenter;

    /**
     * the default constructor
     */
    public LoginViewModel() {
        presenter = new LoginPresenter();
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setEmployeeDAO(new EmployeeDAOMemory());
        presenter.setManagementDAO(new ManagementDAOMemory());
    }

    /**
     * @return the presenter instance
     */
    public LoginPresenter getPresenter() {
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}