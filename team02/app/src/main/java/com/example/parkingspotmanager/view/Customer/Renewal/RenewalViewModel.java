package com.example.parkingspotmanager.view.Customer.Renewal;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.RenewalDAOMemory;

/**
 * The RenewalViewModel class is responsible for managing the data and business logic
 * related to customer account balance renewal. It interacts with the RenewalPresenter
 * and ensures that the presenter is properly initialized and cleaned up.
 */
public class RenewalViewModel extends ViewModel {
    private RenewalPresenter presenter;

    /**
     * Constructor for RenewalViewModel. Initializes the presenter and sets up the DAOs.
     */
    public RenewalViewModel() {
        presenter = new RenewalPresenter();
        presenter.setRenewalDAO(new RenewalDAOMemory());
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /**
     * Returns the RenewalPresenter instance associated with this ViewModel.
     *
     * @return The RenewalPresenter instance.
     */
    public RenewalPresenter getPresenter() {
        return presenter;
    }

    /**
     * Cleans up resources when the ViewModel is no longer used.
     * This method is called when the ViewModel is about to be destroyed.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}