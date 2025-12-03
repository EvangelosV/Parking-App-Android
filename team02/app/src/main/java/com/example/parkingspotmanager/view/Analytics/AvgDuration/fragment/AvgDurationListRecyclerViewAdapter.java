package com.example.parkingspotmanager.view.Analytics.AvgDuration.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.view.Analytics.AvgDuration.fragment.AvgDurationListFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;

public class AvgDurationListRecyclerViewAdapter extends RecyclerView.Adapter<AvgDurationListRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<ParkingSpace> mValues;
    private final AvgDurationListFragment.OnListFragmentInteractionListener mListener;

    public AvgDurationListRecyclerViewAdapter(ArrayList<ParkingSpace> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_avg_duration_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ParkingSpace currentParkingSpace = mValues.get(position);
        holder.mItem = currentParkingSpace;
        holder.txtParkingSpaceId.setText("Parking Space ID: " + currentParkingSpace.getParkingSpaceId());
        holder.btnSelect.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void updateData(ArrayList<ParkingSpace> parkingSpaces) {
        mValues.clear();
        mValues.addAll(parkingSpaces);
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtParkingSpaceId;
        public final ImageButton btnSelect;
        public ParkingSpace mItem;

        /**
         * Constructor for ViewHolder.
         *
         * @param view The view for the item.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtParkingSpaceId = view.findViewById(R.id.txt_parking_space);
            btnSelect = view.findViewById(R.id.btn_select_avg_duration);
        }

        /**
         * Returns a string representation of the ViewHolder.
         *
         * @return A string representation of the ViewHolder.
         */
        @Override
        public String toString() {
            return super.toString() + " '" + txtParkingSpaceId.getText() + "'";
        }
    }
}
