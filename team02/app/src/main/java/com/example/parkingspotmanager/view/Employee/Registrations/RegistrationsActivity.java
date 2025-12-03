package com.example.parkingspotmanager.view.Employee.Registrations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.view.Employee.EmployeePage.EmployeePageActivity;
import com.example.parkingspotmanager.view.Employee.Registrations.fragmemt.RegistrationListFragment;

import java.util.ArrayList;

/**
 * The RegistrationsActivity class represents the activity for handling customer registrations.
 * It allows employees to view, accept, or decline pending registrations.
 */
public class RegistrationsActivity extends AppCompatActivity implements RegistrationsView, View.OnClickListener, RegistrationListFragment.OnListFragmentInteractionListener {
    private static final String EMPLOYEE_USERNAME_EXTRA = "employee_username_extra";
    private static AlertDialog popup;
    private RegistrationsViewModel viewModel;
    private ImageButton btnHome;
    private Registration registrationSelected;
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
        setContentView(R.layout.activity_registration);
        employeeUsername = this.getIntent().getStringExtra(EMPLOYEE_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(RegistrationsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findEmployeeInfo(employeeUsername);

        btnHome = findViewById(R.id.imageButton);
        btnHome.setOnClickListener(v -> viewModel.getPresenter().onHomePage());

        if (findViewById(R.id.fragment_container_registration) != null) {
            if (savedInstanceState != null) {
                return;
            }
            RegistrationListFragment registrationListFragment = RegistrationListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_registration, registrationListFragment).commit();
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
            viewModel.getPresenter().acceptRegistration(registrationSelected);
            ArrayList<Registration> filteredList = viewModel.getPresenter().getRegistrations();
            updateRegistrationList(filteredList);
            popup.dismiss();
        } else if (view.getId() == R.id.decline_registration_popup) {
            viewModel.getPresenter().declineRegistration(registrationSelected);
            popup.dismiss();
        }
    }

    /** show popup when employee selects a registration
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

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        return dialog;
    }

    /**
     * Updates the list of registrations displayed in the fragment.
     *
     * @param filteredList The filtered list of registrations.
     */
    private void updateRegistrationList(ArrayList<Registration> filteredList) {
        RegistrationListFragment fragment = (RegistrationListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_registration);

        if (fragment != null) {
            fragment.updateList(filteredList);
        }
    }

    /**
     * Handles interaction with items in the registration list.
     *
     * @param item The selected registration.
     */
    @Override
    public void onListFragmentInteraction(Registration item) {
        registrationSelected = item;
        popup = showPopup(R.layout.popup_registration, "First Name: " + registrationSelected.getCustomer().getFirstName() +
                        "\nLast Name: " + registrationSelected.getCustomer().getLastName() +
                        "\nEmail: " + registrationSelected.getCustomer().getEmail() +
                        "\nPhone Number: " + registrationSelected.getCustomer().getPhoneNumber() +
                        "\nUsername: " + registrationSelected.getCustomer().getUsername(),
                R.id.accept_registration_popup, R.id.decline_registration_popup);
        popup.show();
    }

    /**
     * get the registrations that the employee has received
     * @return the ArrayList of registrations
     */
    @Override
    public ArrayList<Registration> getRegistrationsList() {
        return viewModel.getPresenter().getRegistrations();
    }

    /**
     * Navigates back to the employee's home page.
     */
    @Override
    public void backToHomePage() {
        Intent intent = new Intent(this, EmployeePageActivity.class);
        intent.putExtra(EMPLOYEE_USERNAME_EXTRA, employeeUsername);
        startActivity(intent);
    }
}