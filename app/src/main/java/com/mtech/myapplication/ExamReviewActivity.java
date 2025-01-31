package com.mtech.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class ExamReviewActivity extends AppCompatActivity {

    private List<String> resultsList;
    private ExamResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_review);

        TextView examNameTextView = findViewById(R.id.tv_examName);
        TextView examDateTextView = findViewById(R.id.tv_examDate);
        RecyclerView resultsRecyclerView = findViewById(R.id.rv_examResults);

        String examName = getIntent().getStringExtra("examName");
        String examDate = getIntent().getStringExtra("examDate");
        String resultsJson = getIntent().getStringExtra("results");

        if (examName == null) examName = "Unknown Exam";
        if (examDate == null) examDate = "Unknown Date";
        if (resultsJson == null) resultsJson = "[]";

        examNameTextView.setText("Exam: " + examName);
        examDateTextView.setText("Date: " + examDate);

        resultsList = new ArrayList<>();
        try {
            JSONArray resultsArray = new JSONArray(resultsJson);
            for (int i = 0; i < resultsArray.length(); i++) {
                resultsList.add(resultsArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new ExamResultsAdapter(resultsList);
        resultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        resultsRecyclerView.setAdapter(adapter);
    }
}
