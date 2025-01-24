package com.mtech.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateGroup2ndActivity extends BaseActivity {

    private TextView timerTextView, gameCodeTextView;
    private Button btnFinish;
    private ImageView inviteFriendIcon;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group2nd);

        // Toolbar setup
        setupToolbar("Group Create", true);

        // TextView এবং Button এর রেফারেন্স নেয়া
        timerTextView = findViewById(R.id.timerTextView);
        gameCodeTextView = findViewById(R.id.gameCodeTextView); // Replace "CODE" TextView ID if needed
        btnFinish = findViewById(R.id.btnFinish);
        inviteFriendIcon = findViewById(R.id.inviteFriendIcon); // Replace ImageView ID if needed

        // গেম কোড সেট করা
        String gameCode = generateGameCode();
        gameCodeTextView.setText(gameCode);

        // ৪ মিনিটের টাইমার শুরু করা
        startTimer(4 * 60 * 1000);

        // ফিনিশ বাটন ক্লিক ইভেন্ট
        btnFinish.setOnClickListener(view -> {
            Toast.makeText(CreateGroup2ndActivity.this, "Game Finished!", Toast.LENGTH_SHORT).show();
            finish(); // Activity বন্ধ করা
        });

        // ইনভাইট ফ্রেন্ড ইমেজ ক্লিক ইভেন্ট
        inviteFriendIcon.setOnClickListener(view -> {
            shareGameCode(gameCode);
        });
    }

    // টাইমার শুরু করার মেথড
    private void startTimer(long durationInMillis) {
        countDownTimer = new CountDownTimer(durationInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;

                // টাইমার আপডেট করা
                String timeLeft = String.format("%02d:%02d", minutes, seconds);
                timerTextView.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Time's up!");
                Toast.makeText(CreateGroup2ndActivity.this, "Time is over!", Toast.LENGTH_SHORT).show();
            }
        };

        countDownTimer.start();
    }

    // গেম কোড জেনারেট করার মেথড
    private String generateGameCode() {
        // ৬ ডিজিটের একটি র‍্যান্ডম কোড তৈরি করা
        int code = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(code);
    }

    // শেয়ার গেম কোড মেথড
    private void shareGameCode(String gameCode) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareMessage = "Join my game! Use this code: " + gameCode;
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // টাইমার বন্ধ করা (যদি অ্যাক্টিভিটি বন্ধ হয়)
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
