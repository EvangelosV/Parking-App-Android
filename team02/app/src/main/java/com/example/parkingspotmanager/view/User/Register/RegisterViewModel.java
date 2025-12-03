package com.example.parkingspotmanager.view.User.Register;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;

/**
 * The `RegisterViewModel` class is responsible for managing the data and business logic
 * for the user registration feature. It interacts with the `RegisterPresenter` to handle
 * user actions and updates the UI accordingly.
 */
public class RegisterViewModel extends ViewModel {

    private RegisterPresenter presenter;

    /**
     * Constructor for the `RegisterViewModel`. Initializes the `RegisterPresenter`
     * and sets the `RegistrationDAO` and `CustomerDAO` to be used for data access operations.
     */
    public RegisterViewModel() {
        presenter = new RegisterPresenter();
        presenter.setRegistrationDAO(new RegistrationDAOMemory());
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /**
     * Retrieves the `RegisterPresenter` instance associated with this ViewModel.
     *
     * @return The `RegisterPresenter` instance.
     */
    public RegisterPresenter getPresenter() {
        return presenter;
    }

    /**
     * Called when the ViewModel is no longer used and will be destroyed.
     * This method clears the reference to the view in the presenter to avoid memory leaks.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}