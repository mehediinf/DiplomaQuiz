package com.mtech.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExamDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_details);

        TextView tvDetails = findViewById(R.id.tv_details);

        // Get data from intent
        String details = getIntent().getStringExtra("examDetails");

        // Display details
        tvDetails.setText(details != null ? details : "No details available.");
    }
}
