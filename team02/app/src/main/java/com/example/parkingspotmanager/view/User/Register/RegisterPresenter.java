package com.example.parkingspotmanager.view.User.Register;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.dao.RegistrationDAO;
import com.example.parkingspotmanager.memorydao.RegistrationDAOMemory;

/**
 * The `RegisterPresenter` class acts as the intermediary between the `RegisterView` and the data layer.
 * It handles the business logic for validating user registration data and saving it to the appropriate DAOs.
 */
public class RegisterPresenter {

    private RegisterView view;
    private CustomerDAO customerDAO;
    private RegistrationDAO registrationDAO;
    private Registration registration;

    /**
     * Default constructor for the `RegisterPresenter`.
     */
    public RegisterPresenter() {
    }

    /**
     * Validates and processes the customer registration data. Checks for empty fields, password length,
     * phone number length, and license plate length. Also ensures that the username, email, and phone number
     * are unique. If all validations pass, the customer data is saved and the user is navigated to the home page.
     */
    public void handleCustomerData() {
        String username = view.getUsername();
        String password = view.getPassword();
        String firstName = view.getFirstName();
        String lastName = view.getLastName();
        String email = view.getEmail();
        String phoneNumber = view.getPhoneNumber();
        String licensePlate = view.getLicensePlate();
        String brand = view.getBrand();
        String model = view.getModel();

        // Validate input fields
        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || licensePlate.isEmpty() || brand.isEmpty() || model.isEmpty()) {
            view.showPopUp(view, "Please fill in all the fields");
        } else if (password.length() < 8) {
            view.showPopUp(view, "Password must be at least 8 characters long");
        } else if (phoneNumber.length() != 10) {
            view.showPopUp(view, "Phone number must be 10 characters long");
        } else if (licensePlate.length() != 7) {
            view.showPopUp(view, "License Plate must be 7 characters long");
        } else {
            // Check for duplicate username, email, or phone number
            if (customerDAO.find(username) != null) {
                view.showPopUp(view, "Username already exists");
                return;
            } else if (customerDAO.findByEmail(email) != null) {
                view.showPopUp(view, "Email already exists");
                return;
            } else if (customerDAO.findByPhone(phoneNumber) != null) {
                view.showPopUp(view, "Phone number already exists");
                return;
            }

            // Create a new registration and save it
            registration = new Registration(new Customer(firstName, lastName, email, phoneNumber, username, password, new Vehicle(licensePlate, brand, model)));
            registrationDAO = new RegistrationDAOMemory();
            registrationDAO.save(registration);

            // Navigate to the home page
            view.startHomePageActivity();
        }
    }

    /**
     * Sets the `RegisterView` instance to be used for updating the UI.
     *
     * @param view The `RegisterView` instance to be set.
     */
    public void setView(RegisterView view) {
        this.view = view;
    }

    /**
     * Clears the reference to the `RegisterView` to avoid memory leaks.
     */
    public void clearView() {
        this.view = null;
    }

    /**
     * Sets the `RegistrationDAO` instance to be used for data access operations.
     *
     * @param registrationDAO The `RegistrationDAO` instance to be set.
     */
    public void setRegistrationDAO(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    /**
     * Sets the `CustomerDAO` instance to be used for data access operations.
     *
     * @param customerDAO The `CustomerDAO` instance to be set.
     */
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Retrieves the current registration object.
     *
     * @return The `Registration` object representing the current registration.
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Retrieves the current `RegisterView` instance.
     *
     * @return The `RegisterView` instance, or `null` if not set.
     */
    public Object getView() {
        return view;
    }
}