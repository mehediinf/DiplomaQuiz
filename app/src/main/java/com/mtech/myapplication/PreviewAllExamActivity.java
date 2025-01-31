package com.mtech.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviewAllExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_all_exam);

        LinearLayout container = findViewById(R.id.previewContainer);

        // Get the examDetails JSON string from the Intent
        String examDetailsJson = getIntent().getStringExtra("examHistory");

        try {
            JSONArray examHistory = new JSONArray(examDetailsJson);
            for (int i = 0; i < examHistory.length(); i++) {
                JSONObject exam = examHistory.getJSONObject(i);
                JSONArray results = exam.getJSONArray("results");

                for (int j = 0; j < results.length(); j++) {
                    String result = results.getString(j);

                    CardView cardView = new CardView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.setMargins(10, 10, 10, 10);
                    cardView.setLayoutParams(layoutParams);
                    cardView.setRadius(16);
                    cardView.setCardElevation(10);
                    cardView.setCardBackgroundColor(getResources().getColor(R.color.cardBackground));

                    LinearLayout contentLayout = new LinearLayout(this);
                    contentLayout.setOrientation(LinearLayout.VERTICAL);
                    contentLayout.setPadding(16, 16, 16, 16);

                    TextView questionText = new TextView(this);
                    questionText.setText(result);
                    questionText.setTextColor(getResources().getColor(R.color.primaryText));
                    questionText.setTextSize(18);
                    contentLayout.addView(questionText);

                    cardView.addView(contentLayout);
                    container.addView(cardView);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}