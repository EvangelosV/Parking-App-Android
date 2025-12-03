package com.example.parkingspotmanager.view.Employee.Registrations.fragmemt;

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
import com.example.parkingspotmanager.domain.Registration;

import java.util.ArrayList;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class RegistrationListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Default constructor
     */
    public RegistrationListFragment() {}

    public static RegistrationListFragment newInstance(int columnCount) {
        RegistrationListFragment fragment = new RegistrationListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creates the layout and initializes the fragment
     * @param savedInstanceState the Instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
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
        View view = inflater.inflate(R.layout.fragment_registration_list, container, false);

        ArrayList<Registration> registrationsList = mListener.getRegistrationsList();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new RegistrationListRecyclerViewAdapter(registrationsList, mListener));
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
     * Updates the list of registrations displayed in the RecyclerView.
     *
     * @param newList The new list of registrations to display.
     */
    public void updateList(ArrayList<Registration> newList) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view_list);
        if (recyclerView.getAdapter() instanceof RegistrationListRecyclerViewAdapter) {
            RegistrationListRecyclerViewAdapter adapter = (RegistrationListRecyclerViewAdapter) recyclerView.getAdapter();
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
         * @param item The selected registration.
         */
        void onListFragmentInteraction(Registration item);

        /**
         * Returns the list of registrations.
         *
         * @return The list of registrations.
         */
        ArrayList<Registration> getRegistrationsList();
    }

}
