package com.mtech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        // Populate history list
        historyList = new ArrayList<>();
        historyList.add(new HistoryItem("PGCB", "10/02/2025"));
        historyList.add(new HistoryItem("DESCO", "12/03/2025"));
        historyList.add(new HistoryItem("DPDC", "15/04/2025"));
        historyList.add(new HistoryItem("PGCB", "10/02/2025"));
        historyList.add(new HistoryItem("DESCO", "12/03/2025"));
        historyList.add(new HistoryItem("DPDC", "15/04/2025"));
        historyList.add(new HistoryItem("PGCB", "10/02/2025"));
        historyList.add(new HistoryItem("DESCO", "12/03/2025"));
        historyList.add(new HistoryItem("DPDC", "15/04/2025"));
        historyList.add(new HistoryItem("PGCB", "10/02/2025"));
        historyList.add(new HistoryItem("DESCO", "12/03/2025"));
        historyList.add(new HistoryItem("DPDC", "15/04/2025"));

        // Set Adapter
        adapter = new HistoryAdapter(historyList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}




