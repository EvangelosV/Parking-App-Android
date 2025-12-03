package com.example.parkingspotmanager.view.Customer.Renewal;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.view.User.Login.LoginView;

/**
 * The RenewalActivity class represents the activity for handling customer account balance renewal.
 * It allows customers to deposit funds into their account and updates the displayed balance.
 */
public class RenewalActivity extends AppCompatActivity implements RenewalView, View.OnClickListener {
    private RenewalViewModel viewModel;
    Button btnRenew;
    TextView txtCustomerUsername;
    TextView txtAccountBalance;
    EditText depositAmnt;
    double deposit;
    private static AlertDialog popup;
    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    private static final String CUSTOMER_BALANCE_EXTRA = "customer_balance_extra";
    private String customerUsername;
    private double AccountBalance;

    /**
     * Initializes the activity, sets up the layout, and binds UI components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_page);
        customerUsername = this.getIntent().getStringExtra(CUSTOMER_USERNAME_EXTRA);
        AccountBalance = this.getIntent().getDoubleExtra(CUSTOMER_BALANCE_EXTRA, 0.0);

        viewModel = new ViewModelProvider(this).get(RenewalViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCustomerInfo(customerUsername);

        txtCustomerUsername = findViewById(R.id.txtCustomerRenewalUsername);
        txtAccountBalance = findViewById(R.id.txtAccountBalance);
        depositAmnt = findViewById(R.id.depositAmnt);
        btnRenew = findViewById(R.id.btnRenew);

        txtCustomerUsername.setText(viewModel.getPresenter().getUsername());
        txtAccountBalance.setText(Double.toString(AccountBalance));
        btnRenew.setOnClickListener(v -> viewModel.getPresenter().onDeposit());
    }

    /**
     * Updates the displayed account balance.
     *
     * @param balance The new account balance to display.
     */
    @Override
    public void updateBalance(double balance) {
        txtAccountBalance.setText(Double.toString(balance));
    }

    /**
     * Retrieves the deposit amount entered by the customer.
     *
     * @return The deposit amount as a double, or 0 if the input is empty.
     */
    @Override
    public double getDeposit() {
        EditText DEPOSIT = (EditText) findViewById(R.id.depositAmnt);
        return DEPOSIT.getText().toString().isEmpty() ? 0 : Double.parseDouble(DEPOSIT.getText().toString());
    }

    /**
     * Displays a popup with a specific layout and message.
     *
     * @param layout The layout resource for the popup.
     * @param msg    The message to display in the popup.
     * @param btn1   The resource ID for the first button.
     * @param btn2   The resource ID for the second button.
     */
    @Override
    public void displayPopUpAction(int layout, String msg, int btn1, int btn2) {
        popup.show();
    }

    /**
     * Handles click events for the activity's buttons.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        // Handle button clicks if needed
    }

    /**
     * Displays a popup with a custom layout and message.
     *
     * @param view The RenewalView interface implementation.
     * @param msg  The message to display in the popup.
     */
    @Override
    public void showPopUp(RenewalView view, String msg) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        Button OKbtn = (Button) customLayout.findViewById(R.id.error_button);
        TextView errorMsg = (TextView) customLayout.findViewById(R.id.error_message);
        errorMsg.setText(msg);
        OKbtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}