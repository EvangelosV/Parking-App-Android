package com.example.parkingspotmanager.view.User.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.HomePage.HomePageActivity;

/**
 * The `RegisterActivity` class is responsible for handling the user registration process.
 * It allows users to input their personal and vehicle details, validates the data,
 * and navigates to the home page upon successful registration.
 */
public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {

    private RegisterViewModel viewModel;

    /**
     * Called when the activity is first created. This method initializes the UI components,
     * sets up the ViewModel, and binds the click listener for the register button.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if there is none.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        System.out.println("RegisterActivity created");

        // Initialize the ViewModel and set up the presenter
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        viewModel.getPresenter().setView(this);

        // Bind the register button and set its click listener
        Button saveBtn = findViewById(R.id.register);
        saveBtn.setOnClickListener(this);
    }

    /**
     * Displays a popup dialog with a custom message. This is typically used to show error messages
     * or other notifications to the user.
     *
     * @param view The view associated with the popup.
     * @param msg  The message to be displayed in the popup.
     */
    @Override
    public void showPopUp(RegisterView view, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        // Set up the OK button and error message in the popup
        Button OKbtn = customLayout.findViewById(R.id.error_button);
        TextView errorMsg = customLayout.findViewById(R.id.error_message);
        errorMsg.setText(msg);

        // Dismiss the dialog when the OK button is clicked
        OKbtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    /**
     * Handles click events for views that implement the `OnClickListener` interface.
     * This method is triggered when the register button is clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.register) {
            System.out.println("Register button clicked");
            viewModel.getPresenter().handleCustomerData();
        }
    }

    /**
     * Navigates to the home page activity after a successful registration.
     */
    @Override
    public void startHomePageActivity() {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    /**
     * Retrieves the username entered by the user in the registration form.
     *
     * @return The username as a String.
     */
    @Override
    public String getUsername() {
        EditText username = findViewById(R.id.usernameregister);
        return username.getText().toString();
    }

    /**
     * Retrieves the password entered by the user in the registration form.
     *
     * @return The password as a String.
     */
    @Override
    public String getPassword() {
        EditText password = findViewById(R.id.passwordregister);
        return password.getText().toString();
    }

    /**
     * Retrieves the first name entered by the user in the registration form.
     *
     * @return The first name as a String.
     */
    @Override
    public String getFirstName() {
        EditText firstName = findViewById(R.id.firstName);
        return firstName.getText().toString();
    }

    /**
     * Retrieves the last name entered by the user in the registration form.
     *
     * @return The last name as a String.
     */
    @Override
    public String getLastName() {
        EditText lastName = findViewById(R.id.lastName);
        return lastName.getText().toString();
    }

    /**
     * Retrieves the email entered by the user in the registration form.
     *
     * @return The email as a String.
     */
    @Override
    public String getEmail() {
        EditText email = findViewById(R.id.email);
        return email.getText().toString();
    }

    /**
     * Retrieves the phone number entered by the user in the registration form.
     *
     * @return The phone number as a String.
     */
    @Override
    public String getPhoneNumber() {
        EditText phoneNumber = findViewById(R.id.phoneNumber);
        return phoneNumber.getText().toString();
    }

    /**
     * Retrieves the license plate entered by the user in the registration form.
     *
     * @return The license plate as a String.
     */
    @Override
    public String getLicensePlate() {
        EditText licensePlate = findViewById(R.id.licensePlate);
        return licensePlate.getText().toString();
    }

    /**
     * Retrieves the vehicle brand entered by the user in the registration form.
     *
     * @return The vehicle brand as a String.
     */
    @Override
    public String getBrand() {
        EditText brand = findViewById(R.id.model);
        return brand.getText().toString();
    }

    /**
     * Retrieves the vehicle model entered by the user in the registration form.
     *
     * @return The vehicle model as a String.
     */
    @Override
    public String getModel() {
        EditText model = findViewById(R.id.model);
        return model.getText().toString();
    }

    /**
     * Sets the username in the registration form.
     *
     * @param username The username to be set.
     */
    @Override
    public void setUsername(String username) {
        EditText Username = findViewById(R.id.usernameregister);
        Username.setText(username);
    }

    /**
     * Sets the password in the registration form.
     *
     * @param password The password to be set.
     */
    @Override
    public void setPassword(String password) {
        EditText Password = findViewById(R.id.passwordregister);
        Password.setText(password);
    }

    /**
     * Sets the first name in the registration form.
     *
     * @param firstName The first name to be set.
     */
    @Override
    public void setFirstName(String firstName) {
        EditText FirstName = findViewById(R.id.firstName);
        FirstName.setText(firstName);
    }

    /**
     * Sets the last name in the registration form.
     *
     * @param lastName The last name to be set.
     */
    @Override
    public void setLastName(String lastName) {
        EditText LastName = findViewById(R.id.lastName);
        LastName.setText(lastName);
    }

    /**
     * Sets the email in the registration form.
     *
     * @param email The email to be set.
     */
    @Override
    public void setEmail(String email) {
        EditText Email = findViewById(R.id.email);
        Email.setText(email);
    }

    /**
     * Sets the phone number in the registration form.
     *
     * @param phoneNumber The phone number to be set.
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        EditText PhoneNumber = findViewById(R.id.phoneNumber);
        PhoneNumber.setText(phoneNumber);
    }

    /**
     * Sets the license plate in the registration form.
     *
     * @param licensePlate The license plate to be set.
     */
    @Override
    public void setLicensePlate(String licensePlate) {
        EditText LicensePlate = findViewById(R.id.licensePlate);
        LicensePlate.setText(licensePlate);
    }

    /**
     * Sets the vehicle brand in the registration form.
     *
     * @param brand The vehicle brand to be set.
     */
    @Override
    public void setBrand(String brand) {
        EditText Brand = findViewById(R.id.model);
        Brand.setText(brand);
    }

    /**
     * Sets the vehicle model in the registration form.
     *
     * @param model The vehicle model to be set.
     */
    @Override
    public void setModel(String model) {
        EditText Model = findViewById(R.id.model);
        Model.setText(model);
    }
}