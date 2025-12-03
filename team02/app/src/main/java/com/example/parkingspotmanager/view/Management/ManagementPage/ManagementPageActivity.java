package com.example.parkingspotmanager.view.Management.ManagementPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.HomePage.HomePageActivity;
import com.example.parkingspotmanager.view.Management.Analytics.AnalyticsActivity;

/**
 * The `ManagementPageActivity` class is the main activity for the management interface of the parking spot manager app.
 * It allows management users to view their username, navigate to analytics, and log out.
 */
public class ManagementPageActivity extends AppCompatActivity implements ManagementPageView, View.OnClickListener {

    private ManagementPageViewModel viewModel;
    private Button btnAnalytics;
    private Button btnLogout;
    private TextView txtManagementUsername;
    private static final String MANAGEMENT_USERNAME_EXTRA = "management_username_extra";
    private String managementUsername;

    /**
     * Called when the activity is first created. This method initializes the UI components,
     * retrieves the management username from the intent, and sets up the ViewModel and presenter.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if there is none.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_page);

        // Retrieve the management username from the intent
        managementUsername = this.getIntent().getStringExtra(MANAGEMENT_USERNAME_EXTRA);

        // Initialize the ViewModel and set up the presenter
        viewModel = new ViewModelProvider(this).get(ManagementPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().getManagementInfo(managementUsername);

        // Initialize UI components
        txtManagementUsername = findViewById(R.id.txtManagementUsername);
        btnAnalytics = findViewById(R.id.btnAnalytics);
        btnLogout = findViewById(R.id.btnLogout);

        // Set the management username in the TextView
        txtManagementUsername.setText(viewModel.getPresenter().getManagementUsername());

        // Set click listeners for the buttons
        btnAnalytics.setOnClickListener(v -> viewModel.getPresenter().onAnalytics());
        btnLogout.setOnClickListener(v -> viewModel.getPresenter().onLogout());
    }

    /**
     * Handles the logout action. Displays a toast message and navigates the user back to the home page.
     */
    @Override
    public void toLogout() {
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    /**
     * Handles the navigation to the analytics section. This method should navigate the user
     * to a screen or fragment where analytics data is displayed.
     */
    @Override
    public void toAnalytics() {
        Toast.makeText(this, "Analytics", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnalyticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}