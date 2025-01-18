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

public class NotificationFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<Notification> notificationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Prepare notification data
        notificationList = new ArrayList<>();

        // Add new notifications first
        notificationList.add(0, new Notification("Urgent Update: Server Maintenance", "The server will be down for maintenance at 10:00 PM tonight."));
        notificationList.add(0, new Notification("System Alert: Security Update", "A critical security update is required to protect your data. Please update immediately."));

        // Add other notifications
        notificationList.add(new Notification("Live Exam at 9:00 PM", "Your live exam will start at 9:00 PM. Please join on time."));
        notificationList.add(new Notification("New Assignment Added", "A new assignment on 'Data Structures' has been added to your course."));
        notificationList.add(new Notification("Exam Results Published", "The results of the midterm exams have been published."));
        notificationList.add(new Notification("Holiday Announcement", "Next Friday is declared a holiday for all departments."));
        notificationList.add(new Notification("Fee Submission Deadline", "The deadline for fee submission is extended to 25th January."));

        // Set up adapter
        adapter = new NotificationAdapter(getContext(), notificationList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
