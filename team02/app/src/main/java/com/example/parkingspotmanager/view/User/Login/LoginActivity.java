package com.example.parkingspotmanager.view.User.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.Customer.CustomerPage.CustomerPageActivity;
import com.example.parkingspotmanager.view.Employee.EmployeePage.EmployeePageActivity;
import com.example.parkingspotmanager.view.Management.ManagementPage.ManagementPageActivity;

/**
 * The `LoginActivity` class is responsible for handling the login functionality of the application.
 * It allows users to enter their credentials and navigate to the appropriate page based on their role
 * (Customer, Employee, or Management).
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private LoginViewModel viewModel;
    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    private static final String EMPLOYEE_USERNAME_EXTRA = "employee_username_extra";
    private static final String MANAGEMENT_USERNAME_EXTRA = "management_username_extra";

    /**
     * Called when the activity is first created. This method initializes the UI components,
     * sets up the ViewModel, and binds the click listener for the login button.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if there is none.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the ViewModel and set up the presenter
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);

        // Bind the login button and set its click listener
        Button loginBtn = findViewById(R.id.loginButtonLoginMenu);
        loginBtn.setOnClickListener(this);
    }

    /**
     * Retrieves the username entered by the user in the login form.
     *
     * @return The username as a String.
     */
    @Override
    public String getUsername() {
        EditText USERNAME = findViewById(R.id.usernamelogin);
        return USERNAME.getText().toString();
    }

    /**
     * Retrieves the password entered by the user in the login form.
     *
     * @return The password as a String.
     */
    @Override
    public String getPassword() {
        EditText PASSWORD = findViewById(R.id.passwordlogin);
        return PASSWORD.getText().toString();
    }

    /**
     * Displays a popup dialog with a custom message. This is typically used to show error messages
     * or other notifications to the user.
     *
     * @param view The view associated with the popup.
     * @param msg  The message to be displayed in the popup.
     */
    @Override
    public void showPopUp(LoginView view, String msg) {
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
     * This method is triggered when the login button is clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginButtonLoginMenu) {
            viewModel.getPresenter().validateCredentials();
        }
    }

    /**
     * Navigates to the Customer Page activity after a successful login.
     *
     * @param username The username of the logged-in customer.
     */
    public void startCustomerPage(String username) {
        Toast.makeText(this, "LOGGED IN", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CustomerPageActivity.class);
        intent.putExtra(CUSTOMER_USERNAME_EXTRA, username);
        startActivity(intent);
    }

    /**
     * Navigates to the Employee Page activity after a successful login.
     *
     * @param username The username of the logged-in employee.
     */
    public void startEmployeePage(String username) {
        Toast.makeText(this, "LOGGED IN", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, EmployeePageActivity.class);
        intent.putExtra(EMPLOYEE_USERNAME_EXTRA, username);
        startActivity(intent);
    }

    /**
     * Navigates to the Management Page activity after a successful login.
     *
     * @param username The username of the logged-in management user.
     */
    public void startManagementPage(String username) {
        Toast.makeText(this, "LOGGED IN", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ManagementPageActivity.class);
        intent.putExtra(MANAGEMENT_USERNAME_EXTRA, username);
        startActivity(intent);
    }
}