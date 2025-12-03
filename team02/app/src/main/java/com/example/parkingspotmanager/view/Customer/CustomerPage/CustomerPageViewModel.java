package com.example.parkingspotmanager.view.Customer.CustomerPage;

import androidx.lifecycle.ViewModel;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;

/**
 * ViewModel class for the CustomerPage
 */
public class CustomerPageViewModel extends ViewModel {
    CustomerPagePresenter presenter;

    /**
     * Default constructor
     */
    public CustomerPageViewModel() {
        presenter = new CustomerPagePresenter();
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /**
     * Method to get the presenter
     * @return presenter
     */
    public CustomerPagePresenter getPresenter() {
        return presenter;
    }

    /**
     * Method to clear the view
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
