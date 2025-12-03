package com.example.parkingspotmanager.view.Customer.Reservations.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.ReservationTicket;
import com.example.parkingspotmanager.view.Customer.SearchParking.fragment.SearchParkingListFragment;

import java.util.ArrayList;
public class ReservationsListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private ReservationsListFragment.OnListFragmentInteractionListener mListener;

    public ReservationsListFragment() {

    }

    public static ReservationsListFragment newInstance(int columnCount) {
        ReservationsListFragment fragment = new ReservationsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
     /*reservations.add(new ReservationTicket(new Reservation("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1")));
    reservations.add(new ReservationTicket(new Reservation("2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2")));
    reservations.add(new ReservationTicket(new Reservation("3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3")));
    reservations.add(new ReservationTicket(new Reservation("4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4")));
    reservations.add(new ReservationTicket(new Reservation("5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5")));*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation_list, container, false);
        ArrayList<ReservationTicket> reservations = mListener.getReservationsList();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new ReservationsListRecyclerViewAdapter(reservations, mListener));
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchParkingListFragment.OnListFragmentInteractionListener) {
            mListener = (ReservationsListFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ReservationTicket item);
        ArrayList<ReservationTicket> getReservationsList();
    }
}
