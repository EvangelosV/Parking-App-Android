package com.example.parkingspotmanager.view.HomePage;

import androidx.lifecycle.ViewModel;

/**
 * The HomePageViewModel class is responsible for managing the data and business logic
 * related to the home page. It interacts with the HomePagePresenter and ensures
 * that the presenter is properly initialized and cleaned up.
 */
public class HomePageViewModel extends ViewModel {
    private HomePagePresenter presenter;

    /**
     * Constructor for HomePageViewModel. Initializes the presenter.
     */
    public HomePageViewModel() {
        presenter = new HomePagePresenter();
    }

    /**
     * Returns the HomePagePresenter instance associated with this ViewModel.
     *
     * @return The HomePagePresenter instance.
     */
    public HomePagePresenter getPresenter() {
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