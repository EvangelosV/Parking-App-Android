package com.example.parkingspotmanager.view.Analytics.AvgDuration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.view.Analytics.AvgDuration.fragment.AvgDurationListFragment;


import java.util.ArrayList;

public class AvgDurationActivity extends AppCompatActivity implements AvgDurationView, View.OnClickListener,AvgDurationListFragment.OnListFragmentInteractionListener {

    private Button btnSearch;
    private AvgDurationViewModel viewModel;
    private EditText parkingspaceIdForSearch;
    private ParkingSpace parkingSpaceSelected;
    private static AlertDialog popup;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avg_duration);

        viewModel = new ViewModelProvider(this).get(AvgDurationViewModel.class);
        viewModel.getPresenter().setView(this);

        parkingspaceIdForSearch = findViewById(R.id.parking_space_avg_duration);
        btnSearch = findViewById(R.id.btn_avg_duration);

        btnSearch.setOnClickListener(v ->{
            String ParkingSpaceID = parkingspaceIdForSearch.getText().toString();
            ArrayList<ParkingSpace> filteredParkingList;
            if(ParkingSpaceID.isEmpty()) {
                filteredParkingList = viewModel.getPresenter().getParkingSpaceDAO().findAll();
            }else{
                int parkingSpaceID = Integer.parseInt(parkingspaceIdForSearch.getText().toString());
                filteredParkingList = viewModel.getPresenter().onSearchParkingSpace(parkingSpaceID);
            }
            updateParkingSpaceList(filteredParkingList);
        });

        if (findViewById(R.id.fragment_container_avg_duration) != null) {
            if (savedInstanceState != null) {
                return;
            }
            AvgDurationListFragment avgDurationListFragment = AvgDurationListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_avg_duration, avgDurationListFragment).commit();
        }
    }

    public void updateParkingSpaceList(ArrayList<ParkingSpace> parkingSpaces) {
        AvgDurationListFragment fragment = (AvgDurationListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_avg_duration);

        if (fragment != null) {
            fragment.updateList(parkingSpaces);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public AlertDialog showPopup(int layoutId, String msg) {
        return null;
    }

    @Override
    public ArrayList<ParkingSpace> getParkingSpaceList() {
        return viewModel.getPresenter().getParkingSpaceDAO().findAll();
    }

    @Override
    public void onListFragmentInteraction(ParkingSpace item) {
        parkingSpaceSelected = item;
    }
    @Override
    public void backToHomePage() {

    }
}
