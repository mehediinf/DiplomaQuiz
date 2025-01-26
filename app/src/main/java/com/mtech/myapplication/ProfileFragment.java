package com.mtech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private HistoryAdapter adapter;
    private List<HistoryItem> historyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize history list and adapter
        historyList = new ArrayList<>();
        adapter = new HistoryAdapter(historyList);
        recyclerView.setAdapter(adapter);

        // Add some initial data
        addHistoryItem("PGCB", "10/02/2025");
        addHistoryItem("DESCO", "12/03/2025");
        addHistoryItem("DPDC", "15/04/2025");

        // Add a button to add new data dynamically
        Button addDataButton = view.findViewById(R.id.btn_add_data);
        addDataButton.setOnClickListener(v -> {
            addHistoryItem("Dynamic Entry", "26/01/2025");
        });

        return view;
    }

    // Method to add new data dynamically
    private void addHistoryItem(String title, String date) {
        historyList.add(new HistoryItem(title, date)); // Add new item to the list
        adapter.notifyDataSetChanged(); // Notify adapter to refresh RecyclerView
    }
}
