package com.mtech.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BanglaQuizActivity extends AppCompatActivity {


    private LinearLayout questionContainer;
    private ArrayList<Question> questions;
    private int currentIndex = 0;
    private TextView timerTextView; // Timer display
    private CountDownTimer countDownTimer; // Timer instance
    private static final long TIME_LIMIT = 180000; // 3 minutes in milliseconds
    private static final String PREFS_NAME = "QuizAppPrefs"; // SharedPreferences Name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_quiz);



        questionContainer = findViewById(R.id.questionContainer);
        timerTextView = findViewById(R.id.timerTextView); // Timer TextView in the layout
        questions = QuestionBank.getQuestions();

        startTimer(); // Start the timer
        loadQuestions();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(TIME_LIMIT, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer display
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                timerTextView.setText(String.format("Time Left: %02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                // Time is up, submit the quiz automatically
                handleSubmit();
            }
        };
        countDownTimer.start();
    }

    private void loadQuestions() {
        for (Question question : questions) {
            // Add Subject Title
            TextView subjectTitle = new TextView(this);
            subjectTitle.setText(question.getSubject());
            subjectTitle.setTextSize(18);
            subjectTitle.setTypeface(Typeface.DEFAULT_BOLD);
            questionContainer.addView(subjectTitle);

            // Add Question
            TextView questionText = new TextView(this);
            questionText.setText(question.getQuestionText());
            questionText.setTextSize(16);
            questionContainer.addView(questionText);

            // Add Options
            RadioGroup optionsGroup = new RadioGroup(this);
            for (int i = 0; i < question.getOptions().length; i++) {
                RadioButton option = new RadioButton(this);
                option.setText(question.getOptions()[i]);
                option.setId(i);

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
        }

        // Add Submit Button
        Button submitButton = new Button(this);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(v -> handleSubmit());
        questionContainer.addView(submitButton);
    }



    private void handleSubmit() {
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Stop the timer if quiz is submitted
        }

        int score = 0;
        int totalQuestions = questions.size();
        currentIndex = 0; // Reset currentIndex for iteration

        for (int i = 0; i < questionContainer.getChildCount(); i++) {
            View view = questionContainer.getChildAt(i);
            if (view instanceof RadioGroup) {
                RadioGroup group = (RadioGroup) view;
                int selectedId = group.getCheckedRadioButtonId();
                if (selectedId != -1 && questions.get(currentIndex).getCorrectAnswerIndex() == selectedId) {
                    score++;
                }
                currentIndex++;
            }
        }

        // Save Exam History
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        JSONArray examHistory = new JSONArray();
        String previousExams = prefs.getString("ExamHistory", "[]");

        try {
            // Load previous exam history
            examHistory = new JSONArray(previousExams);

            // Create JSON object for the current exam
            JSONObject currentExam = new JSONObject();
            currentExam.put("score", score);
            currentExam.put("totalQuestions", totalQuestions);

            // Add answered questions
            JSONArray answeredQuestions = new JSONArray();
            for (int i = 0; i < questions.size(); i++) {
                JSONObject answeredQuestion = new JSONObject();
                answeredQuestion.put("question", questions.get(i).getQuestionText());

                // Check if an option is selected
                RadioGroup optionsGroup = (RadioGroup) questionContainer.getChildAt(3 * i + 2); // Index based on layout
                int selectedOptionId = optionsGroup.getCheckedRadioButtonId();

                if (selectedOptionId != -1) {
                    answeredQuestion.put("yourAnswer", questions.get(i).getOptions()[selectedOptionId]);
                } else {
                    answeredQuestion.put("yourAnswer", "Not Answered");
                }

                answeredQuestion.put("correctAnswer", questions.get(i).getOptions()[questions.get(i).getCorrectAnswerIndex()]);
                answeredQuestions.put(answeredQuestion);
            }

            currentExam.put("answeredQuestions", answeredQuestions);

            // Add current exam to history
            examHistory.put(currentExam);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Save updated exam history
        editor.putString("ExamHistory", examHistory.toString());
        editor.apply();

        // Move to ResultActivity
        Intent intent = new Intent(BanglaQuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score); // Pass the score
        intent.putExtra("totalQuestions", totalQuestions); // Pass total questions
        startActivity(intent);
        finish(); // Close QuizActivity
    }
}