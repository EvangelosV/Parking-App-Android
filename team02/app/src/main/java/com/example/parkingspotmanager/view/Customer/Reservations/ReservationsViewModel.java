package com.example.parkingspotmanager.view.Customer.Reservations;

import androidx.lifecycle.ViewModel;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationTicketDAOMemory;

public class ReservationsViewModel extends ViewModel {
    ReservationsPresenter presenter;

    /**
     * Default constructor
     */
    public ReservationsViewModel() {
        presenter = new ReservationsPresenter();
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setReservationDAO(new ReservationDAOMemory());
        presenter.setReservationTicketDAO(new ReservationTicketDAOMemory());
    }

    /**
     * Method to get the presenter
     * @return presenter
     */
    public ReservationsPresenter getPresenter() {
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
