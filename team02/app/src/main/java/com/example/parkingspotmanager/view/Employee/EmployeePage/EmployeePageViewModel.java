package com.example.parkingspotmanager.view.Employee.EmployeePage;

import androidx.lifecycle.ViewModel;
import com.example.parkingspotmanager.memorydao.EmployeeDAOMemory;

/**
 * The EmployeePageViewModel class is responsible for managing the data and business logic
 * related to the employee page. It interacts with the EmployeePagePresenter and ensures
 * that the presenter is properly initialized and cleaned up.
 */
public class EmployeePageViewModel extends ViewModel {
    private EmployeePagePresenter presenter;

    /**
     * Constructor for EmployeePageViewModel. Initializes the presenter and sets up the EmployeeDAO.
     */
    public EmployeePageViewModel() {
        presenter = new EmployeePagePresenter();
        presenter.setEmployeeDAO(new EmployeeDAOMemory());
    }

    /**
     * Returns the EmployeePagePresenter instance associated with this ViewModel.
     *
     * @return The EmployeePagePresenter instance.
     */
    public EmployeePagePresenter getPresenter() {
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