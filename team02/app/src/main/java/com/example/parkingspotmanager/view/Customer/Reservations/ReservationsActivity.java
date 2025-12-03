package com.example.parkingspotmanager.view.Customer.Reservations;

import android.content.Intent;
import android.view.View;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.view.Customer.Reservations.*;
import com.example.parkingspotmanager.view.Customer.CustomerPage.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.Customer.Reservations.fragment.ReservationsListFragment;

import java.util.ArrayList;
import java.util.List;

public class ReservationsActivity extends AppCompatActivity implements ReservationsView, View.OnClickListener{

    private ReservationsViewModel viewModel;
    Button btnReservations;
    private static AlertDialog popup;
    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    TextView txtUsername;
    private String customerUsername;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        customerUsername = this.getIntent().getStringExtra(CUSTOMER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(ReservationsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCustomerInfo(customerUsername);

        btnHome = findViewById(R.id.btnHomePage);
        txtUsername = findViewById(R.id.txtUsername);

        txtUsername.setText("Username :" + viewModel.getPresenter().getCustomer().getUsername());

        if (findViewById(R.id.fragment_container_reservation) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ReservationsListFragment reservationsListFragment = ReservationsListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_reservation, reservationsListFragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public List<Reservation> getReservationsList(){
        return viewModel.getPresenter().getReservationsList();
    }

    @Override
    public void backToHomePage(){
        Intent intent = new Intent(this, CustomerPageActivity.class);
        intent.putExtra(CUSTOMER_USERNAME_EXTRA, customerUsername);
        startActivity(intent);
    }
}