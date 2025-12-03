package com.example.parkingspotmanager.view.HomePage;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;

import com.example.parkingspotmanager.R;
import android.widget.Button;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.view.User.Login.LoginActivity;
import com.example.parkingspotmanager.view.User.Register.RegisterActivity;

/**
 * The HomePageActivity class represents the main activity for the application's home page.
 * It allows users to navigate to the login or registration pages and provides an option to exit the app.
 */
public class HomePageActivity extends AppCompatActivity implements HomePageView {
    private HomePageViewModel viewModel;
    private static boolean first = true;

    /**
     * Initializes the activity, sets up the layout, and binds UI components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (first) {
            new MemoryInitializer().prepareData();
            first = false;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        viewModel.getPresenter().setView(this);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        loginButton.setOnClickListener(v -> viewModel.getPresenter().onLoginAction());
        registerButton.setOnClickListener(v -> viewModel.getPresenter().onRegisterAction());
    }

    /**
     * Navigates to the login page.
     */
    @Override
    public void loginAction() {
        Toast.makeText(this, "LOGIN", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates to the registration page.
     */
    @Override
    public void registerAction() {
        Toast.makeText(this, "REGISTER", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}