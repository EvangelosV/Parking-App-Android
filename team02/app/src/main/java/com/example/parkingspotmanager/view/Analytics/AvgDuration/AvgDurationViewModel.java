package com.example.parkingspotmanager.view.Analytics.AvgDuration;

import androidx.lifecycle.ViewModel;

import com.example.parkingspotmanager.memorydao.ParkingSpaceDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationTicketDAOMemory;


public class AvgDurationViewModel extends ViewModel {
    AvgDurationPresenter presenter;

    public AvgDurationViewModel(){
        presenter = new AvgDurationPresenter();
        presenter.setParkingSpaceDAO(new ParkingSpaceDAOMemory());
        presenter.setReservationTicketDAO(new ReservationTicketDAOMemory());
    }

    public AvgDurationPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
