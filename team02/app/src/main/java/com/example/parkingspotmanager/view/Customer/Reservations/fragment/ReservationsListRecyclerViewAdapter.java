package com.example.parkingspotmanager.view.Customer.Reservations.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.ReservationTicket;

import java.util.ArrayList;
import com.example.parkingspotmanager.view.Customer.Reservations.fragment.ReservationsListFragment.OnListFragmentInteractionListener;

public class ReservationsListRecyclerViewAdapter extends RecyclerView.Adapter<ReservationsListRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<ReservationTicket> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ReservationsListRecyclerViewAdapter(ArrayList<ReservationTicket> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_reservation_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ReservationTicket currentReservation = mValues.get(position);
        holder.mItem = currentReservation;
        holder.txtReservation.setText(currentReservation.getReservation().getAssignedParkingSpace().getParkingBuilding().getBuildingAddress());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtReservation;
        public ReservationTicket mItem;
        public final ImageButton btnSelectReservation;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtReservation = view.findViewById(R.id.txt_Reservation);
            btnSelectReservation = view.findViewById(R.id.btn_select_reservation);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtReservation.getText() + "'";
        }
    }
}
