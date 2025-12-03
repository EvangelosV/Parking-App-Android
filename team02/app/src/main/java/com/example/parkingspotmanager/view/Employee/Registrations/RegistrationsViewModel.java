package com.example.parkingspotmanager.view.Employee.Registrations;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;

public class RegistrationsViewModel extends ViewModel {
    RegistrationsPresenter presenter;

    /**
     * the constructor
     */
    public RegistrationsViewModel() {
        presenter = new RegistrationsPresenter();
        presenter.setEmployeeDAO(new EmployeeDAOMemory());
        presenter.setRegistrationDAO(new RegistrationDAOMemory());
    }

    /** get the presenter
     * @return the RegistrationsPresenter instance
     */
    public RegistrationsPresenter getPresenter() {
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
