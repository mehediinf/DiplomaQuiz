package com.mtech.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends BaseActivity {

    private static final String PREFS_NAME = "QuizAppPrefs";
    private static final String KEY_BEST_SCORE = "BestScore";
    private static final String KEY_TOTAL_SCORE = "TotalScore";
    private static final String KEY_TOTAL_QUIZZES = "TotalQuizzes";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

// Toolbar setup
        setupToolbar("Result", true);

        // Retrieve data from Intent
        int score = getIntent().getIntExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);

        // SharedPreferences to store and retrieve data
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Get previous best score, total score, and total quizzes
        int bestScore = prefs.getInt(KEY_BEST_SCORE, 0);
        int totalScore = prefs.getInt(KEY_TOTAL_SCORE, 0);
        int totalQuizzes = prefs.getInt(KEY_TOTAL_QUIZZES, 0);

        // Update best score
        if (score > bestScore) {
            bestScore = score;
            editor.putInt(KEY_BEST_SCORE, bestScore);
        }

        // Update total score and quizzes
        totalScore += score;
        totalQuizzes++;
        editor.putInt(KEY_TOTAL_SCORE, totalScore);
        editor.putInt(KEY_TOTAL_QUIZZES, totalQuizzes);

        // Save changes to SharedPreferences
        editor.apply();

        // Calculate average performance as percentage
        float averagePerformance = (totalScore / (float) (totalQuestions * totalQuizzes)) * 100;

        // Display the result
        TextView resultTextView = findViewById(R.id.tv_result);
        resultTextView.setText("Your Score: " + score + " / " + totalQuestions);

        // Display additional statistics
        TextView statsTextView = findViewById(R.id.tv_stats);
        statsTextView.setText("Best Score: " + bestScore +
                "\n\nTotal Contribution: " + totalScore +
                "\n\nTotal Exams Taken: " + totalQuizzes +
                "\n\nAverage Performance: " + String.format("%.2f", averagePerformance) + "%");

        // Restart Quiz Button
        Button restartButton = findViewById(R.id.btn_restart);
        restartButton.setOnClickListener(v -> {
          //  Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
           // startActivity(intent);
            finish(); // Close ResultActivity
        });



        // Add a Preview Button in onCreate()
        Button previewButton = findViewById(R.id.btn_preview);
        previewButton.setOnClickListener(v -> {
           // Intent intent = new Intent(ResultActivity.this, PreviewActivity.class);
            //startActivity(intent);
        });







    }
}







