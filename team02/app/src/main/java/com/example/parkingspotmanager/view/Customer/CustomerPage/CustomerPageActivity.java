package com.example.parkingspotmanager.view.Customer.CustomerPage;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.Customer.QRCode.QRCodeActivity;
import com.example.parkingspotmanager.view.Customer.SearchParking.*;
import com.example.parkingspotmanager.view.Customer.Renewal.*;
import com.example.parkingspotmanager.view.HomePage.HomePageActivity;
import com.example.parkingspotmanager.view.Customer.Reservations.*;

/**
 * The CustomerPageActivity class represents the main activity for the customer interface.
 * It allows customers to search for parking spaces, show their QR code, renew their parking,
 * and logout. This activity interacts with the CustomerPageViewModel to handle business logic.
 */
public class CustomerPageActivity extends AppCompatActivity implements CustomerPageView, View.OnClickListener {
    private CustomerPageViewModel viewModel;
    Button btnSearchParkingSpace;
    Button btnShowQRCode;
    Button btnRenewal;
    Button btnReservations;
    Button btnLogout;
    TextView txtCustomerUsername;
    private static AlertDialog popup;
    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    private static final String CUSTOMER_BALANCE_EXTRA = "customer_balance_extra";
    private String customerUsername;
    private double accountBalance;

    /**
     * Initializes the activity, sets up the layout, and binds UI components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        customerUsername = this.getIntent().getStringExtra(CUSTOMER_USERNAME_EXTRA);
        accountBalance = this.getIntent().getDoubleExtra(CUSTOMER_BALANCE_EXTRA, 0.0);

        viewModel = new ViewModelProvider(this).get(CustomerPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCustomerInfo(customerUsername);

        txtCustomerUsername = findViewById(R.id.txtCustomerUsername);
        btnSearchParkingSpace = findViewById(R.id.btnSearchParking);
        btnShowQRCode = findViewById(R.id.btnShowQRCode);
        btnRenewal = findViewById(R.id.btnRenewal);
        btnReservations = findViewById(R.id.btnReservations);
        btnLogout = findViewById(R.id.btnLogout);

        txtCustomerUsername.setText(viewModel.getPresenter().getCustomerUsername());
        btnSearchParkingSpace.setOnClickListener(v -> viewModel.getPresenter().onSearchParkingSpace());
        btnShowQRCode.setOnClickListener(v -> viewModel.getPresenter().onShowQRCode());
        btnRenewal.setOnClickListener(v -> viewModel.getPresenter().onRenewal());
        btnReservations.setOnClickListener(v -> viewModel.getPresenter().onMyReservations());
        btnLogout.setOnClickListener(v -> viewModel.getPresenter().onLogout());
    }

    /**
     * Navigates to the ReservationsActivity to allow the customer to view their reservations.
     */
    @Override
    public void toMyReservations(){
        Toast.makeText(this, "Reservations", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CustomerPageActivity.this, ReservationsActivity.class);
        intent.putExtra("customer_username_extra", customerUsername);
        startActivity(intent);
    }

    /**
     * Navigates to the SearchParkingActivity to allow the customer to search for and book a parking spot.
     */
    @Override
    public void toSearchParking() {
        Toast.makeText(this, "Search Parking", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CustomerPageActivity.this, SearchParkingActivity.class);
        intent.putExtra("customer_username_extra", customerUsername);
        startActivity(intent);
    }

    /**
     * Navigates to the QRCodeActivity to display the customer's QR code.
     */
    @Override
    public void toShowQRCode() {
        Toast.makeText(this, "QRCode", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CustomerPageActivity.this, QRCodeActivity.class);
        intent.putExtra("customer_username_extra", customerUsername);
        startActivity(intent);
    }

    /**
     * Navigates to the RenewalActivity to allow the customer to renew their account balance.
     */
    @Override
    public void toRenewal() {
        Toast.makeText(this, "Renewal", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CustomerPageActivity.this, RenewalActivity.class);
        intent.putExtra("customer_username_extra", customerUsername);
        intent.putExtra("customer_balance_extra", viewModel.getPresenter().findCustomerInfo(customerUsername).getAccountBalance());
        startActivity(intent);
    }


    /**
     * Logs out the customer and navigates back to the HomePageActivity.
     */
    @Override
    public void toLogout() {
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CustomerPageActivity.this, HomePageActivity.class);
        startActivity(intent);
    }

    /**
     * Handles click events for the activity's buttons.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        // Handle button clicks if needed
    }
}