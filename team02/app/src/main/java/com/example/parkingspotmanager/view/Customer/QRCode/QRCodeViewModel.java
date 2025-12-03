package com.example.parkingspotmanager.view.Customer.QRCode;

import androidx.lifecycle.ViewModel;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;

/**
 * The QRCodeViewModel class is responsible for managing the data and business logic
 * related to QR code generation and display. It interacts with the QRCodePresenter
 * and ensures that the presenter is properly initialized and cleaned up.
 */
public class QRCodeViewModel extends ViewModel {
    private QRCodePresenter presenter;

    /**
     * Constructor for QRCodeViewModel. Initializes the presenter and sets up the CustomerDAO.
     */
    public QRCodeViewModel() {
        super();
        presenter = new QRCodePresenter();
        presenter.setCustomerDAO(new CustomerDAOMemory());
    }

    /**
     * Returns the QRCodePresenter instance associated with this ViewModel.
     *
     * @return The QRCodePresenter instance.
     */
    public QRCodePresenter getPresenter() {
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