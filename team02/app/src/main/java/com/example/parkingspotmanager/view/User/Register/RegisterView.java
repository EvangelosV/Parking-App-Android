package com.example.parkingspotmanager.view.User.Register;

/**
 * The `RegisterView` interface defines the contract for the view in the user registration feature.
 * It specifies the methods that must be implemented by any class acting as the view for user registration.
 */
public interface RegisterView {

    /**
     * Retrieves the username entered by the user in the registration form.
     *
     * @return The username as a String.
     */
    String getUsername();

    /**
     * Retrieves the password entered by the user in the registration form.
     *
     * @return The password as a String.
     */
    String getPassword();

    /**
     * Retrieves the first name entered by the user in the registration form.
     *
     * @return The first name as a String.
     */
    String getFirstName();

    /**
     * Retrieves the last name entered by the user in the registration form.
     *
     * @return The last name as a String.
     */
    String getLastName();

    /**
     * Retrieves the email entered by the user in the registration form.
     *
     * @return The email as a String.
     */
    String getEmail();

    /**
     * Retrieves the phone number entered by the user in the registration form.
     *
     * @return The phone number as a String.
     */
    String getPhoneNumber();

    /**
     * Retrieves the license plate entered by the user in the registration form.
     *
     * @return The license plate as a String.
     */
    String getLicensePlate();

    /**
     * Retrieves the vehicle brand entered by the user in the registration form.
     *
     * @return The vehicle brand as a String.
     */
    String getBrand();

    /**
     * Retrieves the vehicle model entered by the user in the registration form.
     *
     * @return The vehicle model as a String.
     */
    String getModel();

    /**
     * Sets the username in the registration form.
     *
     * @param username The username to be set.
     */
    void setUsername(String username);

    /**
     * Sets the password in the registration form.
     *
     * @param password The password to be set.
     */
    void setPassword(String password);

    /**
     * Sets the first name in the registration form.
     *
     * @param firstName The first name to be set.
     */
    void setFirstName(String firstName);

    /**
     * Sets the last name in the registration form.
     *
     * @param lastName The last name to be set.
     */
    void setLastName(String lastName);

    /**
     * Sets the email in the registration form.
     *
     * @param email The email to be set.
     */
    void setEmail(String email);

    /**
     * Sets the phone number in the registration form.
     *
     * @param phoneNumber The phone number to be set.
     */
    void setPhoneNumber(String phoneNumber);

    /**
     * Sets the license plate in the registration form.
     *
     * @param licensePlate The license plate to be set.
     */
    void setLicensePlate(String licensePlate);

    /**
     * Sets the vehicle brand in the registration form.
     *
     * @param brand The vehicle brand to be set.
     */
    void setBrand(String brand);

    /**
     * Sets the vehicle model in the registration form.
     *
     * @param model The vehicle model to be set.
     */
    void setModel(String model);

    /**
     * Displays a popup dialog with a custom message. This is typically used to show error messages
     * or other notifications to the user.
     *
     * @param view    The view associated with the popup.
     * @param message The message to be displayed in the popup.
     */
    void showPopUp(RegisterView view, String message);

    /**
     * Navigates to the home page activity after a successful registration.
     */
    void startHomePageActivity();
}