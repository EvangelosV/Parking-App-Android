package com.example.parkingspotmanager.view.Management.Analytics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.Analytics.AvgDuration.AvgDurationActivity;
import com.example.parkingspotmanager.view.Analytics.AvgOccupancy.AvgOccupancyActivity;
import com.example.parkingspotmanager.view.Analytics.MonthlyRevenue.MonthlyRevenueActivity;

public class AnalyticsActivity  extends AppCompatActivity implements AnalyticsView, View.OnClickListener{
    private AnalyticsViewModel viewModel;
    private Button btnAvgOccupancy;
    private Button btnMonthlyRevenue;
    private Button btnAvgDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        // Initialize the ViewModel and set up the presenter
        viewModel = new ViewModelProvider(this).get(AnalyticsViewModel.class);
        viewModel.getPresenter().setView(this);

        // Initialize UI components
        btnAvgOccupancy = findViewById(R.id.Average_occupancy);
        btnMonthlyRevenue = findViewById(R.id.monthly_revenue);
        btnAvgDuration = findViewById(R.id.average_duration);

        // Set click listeners for the buttons
        btnAvgOccupancy.setOnClickListener(v -> viewModel.getPresenter().onAvgOccupancy());
        btnMonthlyRevenue.setOnClickListener(v -> viewModel.getPresenter().onMonthlyRevenue());
        btnAvgDuration.setOnClickListener(v -> viewModel.getPresenter().onAvgDuration());
    }

    @Override
    public void toAvgOccupancy() {
        Toast.makeText(this, "Average Occupancy", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AvgOccupancyActivity.class);
        startActivity(intent);
    }

    @Override
    public void toMonthlyRevenue() {
        Toast.makeText(this, "Monthly Revenue", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MonthlyRevenueActivity.class);
        startActivity(intent);
    }

    @Override
    public void toAvgDuration() {
        Toast.makeText(this, "Average Duration", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AvgDurationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}
