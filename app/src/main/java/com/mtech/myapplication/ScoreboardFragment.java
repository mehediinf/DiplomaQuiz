package com.mtech.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Student> studentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scoreboard, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data
        studentList = new ArrayList<>();
        studentList.add(new Student("Md Mehedi Hasan", "CSE", 2569, R.drawable.user_avatar));
        studentList.add(new Student("Masum Billah", "EEE", 2420, R.drawable.user_avatar));
        studentList.add(new Student("Shishir", "BBA", 2053, R.drawable.user_avatar));
        studentList.add(new Student("Another Player", "CSE", 1900, R.drawable.user_avatar));
        studentList.add(new Student("Adison Press", "Physics", 1609, R.drawable.user_avatar));
        studentList.add(new Student("Ruben Geidt", "Math", 1469, R.drawable.user_avatar));
        studentList.add(new Student("Jakob Levin", "Economics", 1003, R.drawable.user_avatar));
        studentList.add(new Student("Player X", "CSE", 900, R.drawable.user_avatar));

        // Set up adapter
        myAdapter = new MyAdapter(getContext(), studentList);
        recyclerView.setAdapter(myAdapter);

        return view;
    }
}
