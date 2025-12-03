package com.example.parkingspotmanager.view.Analytics.AvgDuration.fragment;

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
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.view.Customer.SearchParking.fragment.SearchParkingListFragment;

import java.util.ArrayList;

public class AvgDurationListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    public AvgDurationListFragment() {
    }

    public static AvgDurationListFragment newInstance(int columnCount) {
        AvgDurationListFragment fragment = new AvgDurationListFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avg_duration_list, container, false);

        ArrayList<ParkingSpace> parkingSpacesList = mListener.getParkingSpaceList();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if(mColumnCount <= 1){
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }else{
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new AvgDurationListRecyclerViewAdapter(parkingSpacesList, mListener));
        }
        return view;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }

    public void updateList(ArrayList<ParkingSpace> parkingSpaces) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view_list);
        if (recyclerView.getAdapter() instanceof AvgDurationListRecyclerViewAdapter) {
            AvgDurationListRecyclerViewAdapter adapter = (AvgDurationListRecyclerViewAdapter) recyclerView.getAdapter();
            adapter.updateData(parkingSpaces);
        }
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ParkingSpace item);
        ArrayList<ParkingSpace> getParkingSpaceList();
    }
}
