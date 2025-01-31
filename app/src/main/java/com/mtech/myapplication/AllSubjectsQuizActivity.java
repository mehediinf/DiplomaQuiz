package com.mtech.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AllSubjectsQuizActivity extends AppCompatActivity {

    private LinearLayout questionContainer; // Holds all questions
    private TextView timerTextView; // Displays timer
    private ArrayList<Question> questions; // List of all questions
    private CountDownTimer countDownTimer; // Timer instance
    private static final long TIME_LIMIT = 3600000; // 3 minutes in milliseconds
    private static final String PREFS_NAME = "QuizAppPrefs"; // SharedPreferences Name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_subjects_quiz);

        // Initialize views
        questionContainer = findViewById(R.id.questionContainer);
        timerTextView = findViewById(R.id.timerTextView);
        questions = QuestionBank.getQuestions(); // Load questions from QuestionBank

        startTimer(); // Start countdown timer
        loadQuestions(); // Load all questions dynamically
    }

    /**
     * Starts a countdown timer for the quiz.
     */
    private void startTimer() {
        countDownTimer = new CountDownTimer(TIME_LIMIT, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                timerTextView.setText(String.format("Time Left: %02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                handleSubmit(); // Auto-submit on timeout
            }
        };
        countDownTimer.start();
    }

    /**
     * Loads questions and options dynamically into the layout.
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    private void loadQuestions() {
        int questionNumber = 1; // Start numbering from 1

        for (Question question : questions) {
            // Add question text
            TextView questionText = new TextView(this);
            questionText.setText(String.format("%d. %s", questionNumber, question.getQuestionText()));
            questionText.setTextSize(16);
            questionText.setTypeface(Typeface.DEFAULT_BOLD);
            questionText.setTextColor(Color.BLACK); // Set text color to black
            questionContainer.addView(questionText);

            // Add options
            RadioGroup optionsGroup = new RadioGroup(this);
            for (int i = 0; i < question.getOptions().length; i++) {
                RadioButton option = new RadioButton(this);
                option.setText(question.getOptions()[i]);
                option.setId(i);
                option.setTextColor(Color.BLACK); // Set text color to black

                // Add Click Listener to Make it Unclickable After Selection
                option.setOnClickListener(v -> {
                    // Disable all options in the group after one is selected
                    for (int j = 0; j < optionsGroup.getChildCount(); j++) {
                        optionsGroup.getChildAt(j).setClickable(false);
                    }
                });

                optionsGroup.addView(option);
            }
            questionContainer.addView(optionsGroup);
            questionNumber++;
        }

        // Add Submit button
        Button submitButton = new Button(this);
        submitButton.setText("Submit");

        // Set background and text styles
        submitButton.setBackground(getResources().getDrawable(R.drawable.btn_shape_capsule)); // Capsule shape background
        submitButton.setTextSize(18); // Text size
        submitButton.setTextColor(getResources().getColor(R.color.white)); // Text color
        submitButton.setPadding(15, 7, 15, 7); // Padding for inner spacing

        // Set button size and margins
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // Button width
                LinearLayout.LayoutParams.WRAP_CONTENT  // Button height
        );
        params.setMargins(16, 16, 16, 16); // Margins: left, top, right, bottom
        params.gravity = Gravity.CENTER; // Center the button horizontally in its container
        submitButton.setLayoutParams(params);

        // Add shadow for modern look
        submitButton.setElevation(8);

        // Set OnClickListener
        submitButton.setOnClickListener(v -> handleSubmit());

        // Add the button to the container
        questionContainer.addView(submitButton);
    }

    /**
     * Handles quiz submission, calculates the score, and navigates to ResultActivity.
     */
    private void handleSubmit() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        int score = 0;
        int totalQuestions = questions.size();
        int questionIndex = 0;

        JSONArray questionResults = new JSONArray(); // Store results of each question

        for (int i = 0; i < questionContainer.getChildCount(); i++) {
            View view = questionContainer.getChildAt(i);
            if (view instanceof RadioGroup) {
                RadioGroup group = (RadioGroup) view;
                int selectedId = group.getCheckedRadioButtonId();
                String result = (selectedId != -1 && questions.get(questionIndex).getCorrectAnswerIndex() == selectedId) ? "Correct" : "Incorrect";
                questionResults.put("Q" + (questionIndex + 1) + ": " + result); // Add question result
                if (result.equals("Correct")) {
                    score++;
                }
                questionIndex++;
            }
        }

        saveExamHistory(score, totalQuestions, questionResults); // Pass question results

        // Navigate to ResultActivity
        Intent intent = new Intent(AllSubjectsQuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("totalQuestions", totalQuestions);
        startActivity(intent);
        finish();
    }

    /**
     * Saves the exam history in SharedPreferences.
     */
    private void saveExamHistory(int score, int totalQuestions, JSONArray questionResults) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String history = prefs.getString("ExamHistory", "[]");
        try {
            JSONArray examHistory = new JSONArray(history);
            JSONObject currentExam = new JSONObject();
            currentExam.put("examName", "Sample Exam");
            currentExam.put("date", "2025-01-27");
            currentExam.put("score", score);
            currentExam.put("totalQuestions", totalQuestions);
            currentExam.put("results", questionResults); // Add the results of each question

            examHistory.put(currentExam);
            editor.putString("ExamHistory", examHistory.toString());
            editor.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}