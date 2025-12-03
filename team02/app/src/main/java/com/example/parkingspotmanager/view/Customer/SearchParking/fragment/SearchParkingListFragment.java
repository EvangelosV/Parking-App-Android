package com.example.parkingspotmanager.view.Customer.SearchParking.fragment;

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
import com.example.parkingspotmanager.domain.ParkingBuilding;

import java.util.ArrayList;

/**
 * The SearchParkingListFragment class represents a fragment that displays a list of parking buildings.
 * It allows users to interact with the list and select a parking building for further actions.
 */
public class SearchParkingListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Default constructor for SearchParkingListFragment.
     */
    public SearchParkingListFragment() {
    }

    /**
     * Creates a new instance of SearchParkingListFragment with the specified column count.
     *
     * @param columnCount The number of columns to display in the list.
     * @return A new instance of SearchParkingListFragment.
     */
    public static SearchParkingListFragment newInstance(int columnCount) {
        SearchParkingListFragment fragment = new SearchParkingListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Initializes the fragment and retrieves arguments passed to it.
     *
     * @param savedInstanceState If the fragment is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    /**
     * Creates the view for the fragment and initializes the RecyclerView.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container          The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return The View for the fragment's UI.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_parking_list, container, false);

        ArrayList<ParkingBuilding> parkingBuildingList = mListener.getParkingBuildingList();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new SearchParkingListRecyclerViewAdapter(parkingBuildingList, mListener));
        }
        return view;
    }

    /**
     * Attaches the fragment to its context and ensures that the context implements the required interface.
     *
     * @param context The context to attach the fragment to.
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    /**
     * Detaches the fragment from its context and clears the listener reference.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Updates the list of parking buildings displayed in the RecyclerView.
     *
     * @param newList The new list of parking buildings to display.
     */
    public void updateList(ArrayList<ParkingBuilding> newList) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view_list);
        if (recyclerView.getAdapter() instanceof SearchParkingListRecyclerViewAdapter) {
            SearchParkingListRecyclerViewAdapter adapter = (SearchParkingListRecyclerViewAdapter) recyclerView.getAdapter();
            adapter.updateData(newList);
        }
    }

    /**
     * Interface for handling interactions with items in the list.
     */
    public interface OnListFragmentInteractionListener {
        /**
         * Handles interaction with an item in the list.
         *
         * @param item The selected parking building.
         */
        void onListFragmentInteraction(ParkingBuilding item);

        /**
         * Returns the list of parking buildings.
         *
         * @return The list of parking buildings.
         */
        ArrayList<ParkingBuilding> getParkingBuildingList();
    }
}