package com.example.parkingspotmanager.view.Management.ManagementPage;

import androidx.lifecycle.ViewModel;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;

/**
 * The `ManagementPageViewModel` class is responsible for managing the data and business logic
 * for the Management Page feature. It interacts with the `ManagementPagePresenter` to handle
 * user actions and updates the UI accordingly.
 */
public class ManagementPageViewModel extends ViewModel {

    private ManagementPagePresenter presenter;

    /**
     * Constructor for the `ManagementPageViewModel`. Initializes the `ManagementPagePresenter`
     * and sets the `ManagementDAO` to be used for data access operations.
     */
    public ManagementPageViewModel() {
        presenter = new ManagementPagePresenter();
        presenter.setManagementDAO(new ManagementDAOMemory());
    }

    /**
     * Retrieves the `ManagementPagePresenter` instance associated with this ViewModel.
     *
     * @return The `ManagementPagePresenter` instance.
     */
    public ManagementPagePresenter getPresenter() {
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