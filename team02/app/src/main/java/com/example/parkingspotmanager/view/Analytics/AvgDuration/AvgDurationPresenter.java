package com.example.parkingspotmanager.view.Analytics.AvgDuration;

import com.example.parkingspotmanager.dao.ParkingSpaceDAO;
import com.example.parkingspotmanager.dao.ReservationTicketDAO;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.ReservationTicket;
import com.example.parkingspotmanager.memorydao.ParkingSpaceDAOMemory;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AvgDurationPresenter {
    private AvgDurationView view;
    private ParkingSpaceDAO parkingSpaceDAO;
    private ReservationTicketDAO reservationTicketDAO;

    public AvgDurationPresenter(){

    }

    public void setView(AvgDurationView view){
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public void setParkingSpaceDAO(ParkingSpaceDAOMemory parkingSpace){
        parkingSpaceDAO = new ParkingSpaceDAOMemory();
    }

    public void setReservationTicketDAO(ReservationTicketDAO reservationTicketDAO) {
        this.reservationTicketDAO = reservationTicketDAO;
    }

    public ArrayList<ParkingSpace> GetParkingSpaceList(){
        return getParkingSpaceDAO().findAll();
    }

    public ParkingSpaceDAO getParkingSpaceDAO(){
        return parkingSpaceDAO;
    }

    public ReservationTicketDAO getReservationTicketDAO() {
        return reservationTicketDAO;
    }

    public Object getView(){
        return view;
    }

    public ArrayList<ParkingSpace> onSearchParkingSpace(int buildingNumber){
        return parkingSpaceDAO.findParkingSpacesByBuildingId(buildingNumber);
    }

    public double getAvgDuration(int parkingSpaceId) {
        List<LocalTime[]> entryExitTimes = reservationTicketDAO.getEntryExitTimes(parkingSpaceId);

        if (entryExitTimes == null || entryExitTimes.isEmpty()) {
            return 0;
        }

        Duration totalDuration = Duration.ZERO;
        for (LocalTime[] times : entryExitTimes) {
            LocalTime entryTime = times[0];
            LocalTime exitTime = times[1];
            totalDuration = totalDuration.plus(Duration.between(entryTime, exitTime));
        }

        return totalDuration.toMinutes() / (double) entryExitTimes.size();
    }
}
