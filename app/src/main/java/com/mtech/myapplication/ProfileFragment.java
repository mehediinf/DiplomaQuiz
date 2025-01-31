package com.mtech.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExamHistoryAdapter adapter;
    private List<ExamHistoryItem> examHistoryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        examHistoryList = new ArrayList<>();
        adapter = new ExamHistoryAdapter(examHistoryList, this::onExamItemClicked);
        recyclerView.setAdapter(adapter);

        loadExamHistory();

        return view;
    }

    /**
     * Loads exam history from SharedPreferences.
     */
    private void loadExamHistory() {
        SharedPreferences prefs = requireContext().getSharedPreferences("QuizAppPrefs", getContext().MODE_PRIVATE);
        String history = prefs.getString("ExamHistory", "[]");

        try {
            JSONArray historyArray = new JSONArray(history);
            for (int i = 0; i < historyArray.length(); i++) {
                JSONObject exam = historyArray.getJSONObject(i);
                String examName = exam.getString("examName");
                String date = exam.getString("date");
                JSONArray results = exam.getJSONArray("results");

                examHistoryList.add(new ExamHistoryItem(examName, date, results));
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles item click to show exam review.
     */
    private void onExamItemClicked(ExamHistoryItem examHistoryItem) {
        Intent intent = new Intent(getContext(), ExamReviewActivity.class);
        intent.putExtra("examName", examHistoryItem.getExamName());
        intent.putExtra("examDate", examHistoryItem.getExamDate());
        intent.putExtra("results", examHistoryItem.getResults().toString());
        startActivity(intent);
    }
}
