package com.example.parkingspotmanager.view.Customer.SearchParking;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.ParkingBuildingDAOMemory;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;

public class SearchParkingViewModel extends ViewModel{
    SearchParkingPresenter presenter;

    /**
     * the constructor
     */
    public SearchParkingViewModel() {
        presenter = new SearchParkingPresenter();
        presenter.setParkingBuildingDAO(new ParkingBuildingDAOMemory());
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /** get the presenter
     * @return the SearchParkingPresenter instance
     */
    public SearchParkingPresenter getPresenter() {
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
