package com.example.parkingspotmanager.view.Management.Analytics;


public class AnalyticsPresenter {

    private AnalyticsView view;

    public AnalyticsPresenter(){

    }

    public void onAvgOccupancy(){
        view.toAvgOccupancy();
    }

    public void onMonthlyRevenue(){
        view.toMonthlyRevenue();
    }

    public void onAvgDuration(){
        view.toAvgDuration();
    }

    public void setView(AnalyticsView view){
        this.view = view;
    }

    public void clearView(){
        this.view = null;
    }

    public Object getView(){
        return view;
    }

}
