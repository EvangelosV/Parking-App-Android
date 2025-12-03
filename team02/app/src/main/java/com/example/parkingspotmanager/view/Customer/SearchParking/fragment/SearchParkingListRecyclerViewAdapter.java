package com.example.parkingspotmanager.view.Customer.SearchParking.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.ParkingBuilding;

import java.util.ArrayList;
import com.example.parkingspotmanager.view.Customer.SearchParking.fragment.SearchParkingListFragment.OnListFragmentInteractionListener;

/**
 * The SearchParkingListRecyclerViewAdapter class is a RecyclerView adapter that manages the display
 * of parking buildings in a list. It binds data to the views and handles user interactions.
 */
public class SearchParkingListRecyclerViewAdapter extends RecyclerView.Adapter<SearchParkingListRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<ParkingBuilding> mValues;
    private final OnListFragmentInteractionListener mListener;

    /**
     * Constructor for SearchParkingListRecyclerViewAdapter.
     *
     * @param items    The list of parking buildings to display.
     * @param listener The listener for handling item interactions.
     */
    public SearchParkingListRecyclerViewAdapter(ArrayList<ParkingBuilding> items, OnListFragmentInteractionListener listener) {
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
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search_parking_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binds data to the views in the ViewHolder.
     *
     * @param holder   The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ParkingBuilding currentParkingBuilding = mValues.get(position);
        holder.mItem = currentParkingBuilding;
        holder.txtParkingBuildingName.setText(currentParkingBuilding.getBuildingAddress());
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
     * @param newList The new list of parking buildings.
     */
    public void updateData(ArrayList<ParkingBuilding> newList) {
        mValues.clear();
        mValues.addAll(newList);
        notifyDataSetChanged();
    }

    /**
     * The ViewHolder class represents the views for each item in the RecyclerView.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtParkingBuildingName;
        public final ImageButton btnSelect;
        public ParkingBuilding mItem;

        /**
         * Constructor for ViewHolder.
         *
         * @param view The view for the item.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtParkingBuildingName = view.findViewById(R.id.txt_Reservation);
            btnSelect = view.findViewById(R.id.btn_select_reservation);
        }

        /**
         * Returns a string representation of the ViewHolder.
         *
         * @return A string representation of the ViewHolder.
         */
        @Override
        public String toString() {
            return super.toString() + " '" + txtParkingBuildingName.getText() + "'";
        }
    }
}