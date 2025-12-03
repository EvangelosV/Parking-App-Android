package com.example.parkingspotmanager.view.Customer.SearchParking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.view.Customer.CustomerPage.CustomerPageActivity;
import com.example.parkingspotmanager.view.Customer.SearchParking.fragment.SearchParkingListFragment;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * The SearchParkingActivity class represents the activity for searching and booking parking spaces.
 * It allows customers to search for parking buildings by zip code, view details, and book a parking spot.
 */
public class SearchParkingActivity extends AppCompatActivity implements SearchParkingView, View.OnClickListener, SearchParkingListFragment.OnListFragmentInteractionListener {

    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    private static AlertDialog popup;
    private SearchParkingViewModel viewModel;
    private ImageButton btnHome;
    private Button btnSearch;
    private ParkingBuilding parkingBuildingSelected;
    private String customerUsername;
    private EditText EntryTime;
    private EditText ExitTime;
    private EditText zipCodeForSearch;

    /**
     * Initializes the activity, sets up the layout, and binds UI components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_parking);
        customerUsername = this.getIntent().getStringExtra(CUSTOMER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(SearchParkingViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCustomerInfo(customerUsername);

        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());
        zipCodeForSearch = findViewById(R.id.zipSearch);
        btnSearch = findViewById(R.id.btnSearchZip);

        btnSearch.setOnClickListener(v -> {
            String zipCode = zipCodeForSearch.getText().toString();
            ArrayList<ParkingBuilding> filteredBuildingList;
            if (zipCode.isEmpty()) {
                filteredBuildingList = viewModel.getPresenter().getParkingBuildings();
            } else {
                filteredBuildingList = viewModel.getPresenter().
                        onSearchParkingBuilding(zipCode);
            }
            updateParkingBuildingList(filteredBuildingList);
        });

        if (findViewById(R.id.fragment_container_search_parking) != null) {
            if (savedInstanceState != null) {
                return;
            }
            SearchParkingListFragment searchParkingListFragment = SearchParkingListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_search_parking, searchParkingListFragment).commit();
        }
    }

    /**
     * Handles click events for the activity's buttons.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.accept_registration_popup) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime entryTime = LocalTime.parse(EntryTime.getText().toString(), formatter);
                LocalTime exitTime = LocalTime.parse(ExitTime.getText().toString(), formatter);

                boolean available = viewModel.getPresenter().BookSpace(parkingBuildingSelected, entryTime, exitTime);
                if (available) {
                    Toast.makeText(this, "Space booked successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Space not available", Toast.LENGTH_SHORT).show();
                }
                popup.dismiss();
            } catch (DateTimeParseException e) {
                Toast.makeText(this, "Invalid date/time format", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.decline_registration_popup) {
            popup.dismiss();
        }
    }

    /**
     * Updates the list of parking buildings displayed in the fragment.
     *
     * @param filteredList The filtered list of parking buildings.
     */
    private void updateParkingBuildingList(ArrayList<ParkingBuilding> filteredList) {
        SearchParkingListFragment fragment = (SearchParkingListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_search_parking);

        if (fragment != null) {
            fragment.updateList(filteredList);
        }
    }

    /**
     * Handles interaction with items in the parking building list.
     *
     * @param item The selected parking building.
     */
    @Override
    public void onListFragmentInteraction(ParkingBuilding item) {
        parkingBuildingSelected = item;
        popup = showPopup(R.layout.popup_bookspace,
                "Building Address " + parkingBuildingSelected.getBuildingAddress() +
                        "\nBuilding ZIP code " + parkingBuildingSelected.getPostalCode() +
                        "\nAvailable Spaces " + parkingBuildingSelected.getAvailableSpaces() +
                        "\nHours " + parkingBuildingSelected.getOpeningHours() +
                        " - " + parkingBuildingSelected.getClosingHours(),
                R.id.accept_registration_popup,
                R.id.decline_registration_popup);
        popup.show();
    }

    /**
     * get the parking buildings that the customer can park in
     * @return the ArrayList of parking buildings
     */
    @Override
    public ArrayList<ParkingBuilding> getParkingBuildingList() {
        return viewModel.getPresenter().getParkingBuildings();
    }

    /**
     * show popup when customer selects a parking building
     * @param layoutId the layout of the popup
     * @param msg the message of the popup
     * @param btn1 the first button
     * @param btn2 the second button
     * @return the AlertDialog
     */
    @Override
    public AlertDialog showPopup(int layoutId, String msg, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View popupView = getLayoutInflater().inflate(layoutId, null);
        builder.setView(popupView);
        AlertDialog dialog = builder.create();

        TextView textView = (TextView) popupView.findViewById(R.id.txt_register_username);
        textView.setText(msg);
        Button button1 = (Button) popupView.findViewById(btn1);
        Button button2 = (Button) popupView.findViewById(btn2);
        EntryTime = (EditText) popupView.findViewById(R.id.EntryTime);
        ExitTime = (EditText) popupView.findViewById(R.id.ExitTime);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        return dialog;
    }

    /**
     * what happens when the homepage button is pressed
     */
    @Override
    public void backToHomePage() {
        Intent intent = new Intent(this, CustomerPageActivity.class);
        intent.putExtra(CUSTOMER_USERNAME_EXTRA, customerUsername);
        startActivity(intent);
    }
}