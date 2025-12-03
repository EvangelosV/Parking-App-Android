package com.example.parkingspotmanager.view.Employee.Registrations.fragmemt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.Registration;

import java.util.ArrayList;
import com.example.parkingspotmanager.view.Employee.Registrations.fragmemt.RegistrationListFragment.OnListFragmentInteractionListener;

/**
 * The RegistrationListRecyclerViewAdapter class is a RecyclerView adapter that manages the display
 * of customer registrations in a list. It binds data to the views and handles user interactions.
 */
public class RegistrationListRecyclerViewAdapter extends RecyclerView.Adapter<RegistrationListRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Registration> mValues;
    private final OnListFragmentInteractionListener mListener;

    /**
     * Constructor for RegistrationListRecyclerViewAdapter.
     *
     * @param items    The list of registrations to display.
     * @param listener The listener for handling item interactions.
     */
    public RegistrationListRecyclerViewAdapter(ArrayList<Registration> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    /**
     * Creates a new ViewHolder instance for the RecyclerView.
     *
     * @param parent   The parent ViewGroup.
     * @param viewType The type of view.
     * @return A new ViewHolder instance.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_registration_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binds data to the views in the ViewHolder.
     *
     * @param holder   The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Registration currentRegistration = mValues.get(position);
        holder.mItem = currentRegistration;
        holder.txtRegistrationUsername.setText(currentRegistration.getCustomer().getUsername());
        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    /**
     * Returns the number of items in the list.
     *
     * @return The number of items in the list.
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * Updates the data in the adapter and notifies the RecyclerView of changes.
     *
     * @param newList The new list of registrations.
     */
    public void updateData(ArrayList<Registration> newList) {
        mValues.clear();
        mValues.addAll(newList);
        notifyDataSetChanged();
    }

    /**
     * The ViewHolder class represents the views for each item in the RecyclerView.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtRegistrationUsername;
        public final ImageButton btnSelect;
        public Registration mItem;

        /**
         * Constructor for ViewHolder.
         *
         * @param view The view for the item.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtRegistrationUsername = view.findViewById(R.id.txt_username);
            btnSelect = view.findViewById(R.id.btn_select_registration);
        }

        /**
         * Returns a string representation of the ViewHolder.
         *
         * @return A string representation of the ViewHolder.
         */
        @Override
        public String toString() {
            return super.toString() + " '" + txtRegistrationUsername.getText() + "'";
        }
    }
}