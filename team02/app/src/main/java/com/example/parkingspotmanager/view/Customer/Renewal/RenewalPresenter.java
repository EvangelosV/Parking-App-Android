package com.example.parkingspotmanager.view.Customer.Renewal;

import android.widget.TextView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.dao.RenewalDAO;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Status;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.domain.Renewal;
import com.example.parkingspotmanager.memorydao.RenewalDAOMemory;

/**
 * The RenewalPresenter class handles the business logic for customer account balance renewal.
 * It interacts with the RenewalView interface to update the UI and uses the CustomerDAO and RenewalDAO
 * to manage customer and renewal data.
 */
public class RenewalPresenter {

    private RenewalDAOMemory renewalDAO;
    private CustomerDAOMemory customerDAO;
    private Customer customer;
    private RenewalView view;
    private Renewal renewal;

    /**
     * Default constructor for RenewalPresenter.
     */
    public RenewalPresenter() {
    }

    /**
     * Sets the RenewalDAO instance to be used by the presenter.
     *
     * @param renewalDAO The RenewalDAO instance.
     */
    public void setRenewalDAO(RenewalDAOMemory renewalDAO) {
        this.renewalDAO = renewalDAO;
    }

    /**
     * Sets the CustomerDAO instance to be used by the presenter.
     *
     * @param customerDAO The CustomerDAO instance.
     */
    public void setCustomerDAO(CustomerDAOMemory customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Clears the reference to the view interface.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Sets the view interface for this presenter.
     *
     * @param view The RenewalView interface implementation.
     */
    public void setView(RenewalView view) {
        this.view = view;
    }

    /**
     * Handles the deposit action. Validates the deposit amount, creates a renewal request,
     * and updates the customer's account balance.
     */
    public void onDeposit() {
        double deposit = view.getDeposit();
        renewal = new Renewal(customer, deposit);
        if (deposit > 0) {
            renewal.setRenewalStatus(Status.PENDING);
            renewal.setAmount(deposit);
            renewalDAO.save(renewal);
            renewal.processRenewal();
        } else {
            view.showPopUp(view, "Invalid amount");
        }
        view.updateBalance(renewal.getCustomer().getAccountBalance());
    }

    /**
     * Retrieves customer information based on the provided username.
     *
     * @param customerUsername The username of the customer to find.
     * @return The Customer object if found, otherwise null.
     */
    public Customer findCustomerInfo(String customerUsername) {
        if (customerUsername == null)
            return null;
        customer = customerDAO.find(customerUsername);
        return customer;
    }

    /**
     * Returns the username of the current customer.
     *
     * @return The username of the customer, or an empty string if no customer is set.
     */
    public String getUsername() {
        if (customer == null)
            return "";
        return customer.getUsername();
    }

    /**
     * Returns the current view interface.
     *
     * @return The RenewalView interface implementation.
     */
    public Object getView() {
        return view;
    }

    /**
     * Returns the current renewal object.
     *
     * @return The Renewal object.
     */
    public Renewal getRenewal() {
        return renewal;
    }

    /**
     * Returns the CustomerDAO instance used by the presenter.
     *
     * @return The CustomerDAO instance.
     */
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    /**
     * Returns the RenewalDAO instance used by the presenter.
     *
     * @return The RenewalDAO instance.
     */
    public RenewalDAO getRenewalDAO() {
        return renewalDAO;
    }

    /**
     * Sets the renewal object for this presenter.
     *
     * @param renewal The Renewal object.
     */
    public void setRenewal(Renewal renewal) {
        this.renewal = renewal;
    }
}