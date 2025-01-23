package com.mtech.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class JobSyllabusActivity extends BaseActivity {

    LinearLayout llBUETPattern,llBpscPattern, llMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_syllabus);

        // Toolbar setup
        setupToolbar("Syllabus", true);

        llBUETPattern = findViewById(R.id.buetPattern);
        llBpscPattern = findViewById(R.id.bpscPattern);
        llMainLayout = findViewById(R.id.main); // Parent layout to inflate child

        llBUETPattern.setOnClickListener(view -> {
            // Remove previous views (if any) to avoid duplication
            llMainLayout.removeAllViews();

            // Inflate buet_pattern.xml layout
            LayoutInflater inflater = LayoutInflater.from(this);
            View buetPatternView = inflater.inflate(R.layout.buet_pattern, llMainLayout, false);

            // Add the inflated view to the main layout
            llMainLayout.addView(buetPatternView);

            setupToolbar("BUET Pattern", true);
        });


        llBpscPattern.setOnClickListener(view -> {
            // Remove previous views (if any) to avoid duplication
            llMainLayout.removeAllViews();

            // Inflate buet_pattern.xml layout
            LayoutInflater inflater = LayoutInflater.from(this);
            View buetPatternView = inflater.inflate(R.layout.bpsc_pattern, llMainLayout, false);

            // Add the inflated view to the main layout
            llMainLayout.addView(buetPatternView);

            setupToolbar("BPSC Pattern", true);
        });


    }
}
