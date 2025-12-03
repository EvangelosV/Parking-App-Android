package com.example.parkingspotmanager.view.Employee.EmployeePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.Employee.Registrations.RegistrationsActivity;
import com.example.parkingspotmanager.view.HomePage.HomePageActivity;

/**
 * The EmployeePageActivity class represents the main activity for the employee interface.
 * It allows employees to navigate to the registrations page and logout.
 */
public class EmployeePageActivity extends AppCompatActivity implements EmployeePageView, View.OnClickListener {
    private EmployeePageViewModel viewModel;
    TextView txtEmployeeUsername;
    Button btnRegistrations;
    Button btnLogout;
    private static final String EMPLOYEE_USERNAME_EXTRA = "employee_username_extra";
    private String employeeUsername;

    /**
     * Initializes the activity, sets up the layout, and binds UI components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_page);
        employeeUsername = this.getIntent().getStringExtra(EMPLOYEE_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(EmployeePageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findEmployeeInfo(employeeUsername);

        txtEmployeeUsername = findViewById(R.id.txtEmployeeUsername);
        btnRegistrations = findViewById(R.id.btnRegistrations);
        btnLogout = findViewById(R.id.btnLogout);

        txtEmployeeUsername.setText(viewModel.getPresenter().getEmployeeUsername());
        btnRegistrations.setOnClickListener(v -> viewModel.getPresenter().onRegistrations());
        btnLogout.setOnClickListener(v -> viewModel.getPresenter().onLogout());
    }

    /**
     * Handles click events for the activity's buttons.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

    }

    /**
     * Navigates to the RegistrationsActivity.
     */
    @Override
    public void toRegistrations() {
        Toast.makeText(this, "Registrations", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EmployeePageActivity.this, RegistrationsActivity.class);
        intent.putExtra(EMPLOYEE_USERNAME_EXTRA, employeeUsername);
        startActivity(intent);
    }

    /**
     * Logs out the employee and navigates back to the HomePageActivity.
     */
    @Override
    public void toLogout() {
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EmployeePageActivity.this, HomePageActivity.class);
        startActivity(intent);
    }
}