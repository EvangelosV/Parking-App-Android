package com.example.parkingspotmanager.view.Management.Analytics;

import androidx.lifecycle.ViewModel;

public class AnalyticsViewModel extends ViewModel {
    private AnalyticsPresenter presenter;

    public AnalyticsViewModel(){
        presenter = new AnalyticsPresenter();
    }

    public AnalyticsPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
