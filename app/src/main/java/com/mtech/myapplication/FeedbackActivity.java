package com.mtech.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends BaseActivity {

    private EditText etName, etFeedback;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



        // Toolbar setup
        setupToolbar("Feedback", true);

        // Initialize views
        etName = findViewById(R.id.etName);
        etFeedback = findViewById(R.id.etFeedback);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Submit button action
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String feedback = etFeedback.getText().toString().trim();

                // Check if fields are empty
                if (name.isEmpty()) {
                    etName.setError("আপনার নাম দিন");
                    etName.requestFocus();
                    return;
                }

                if (feedback.isEmpty()) {
                    etFeedback.setError("মতামত লিখুন");
                    etFeedback.requestFocus();
                    return;
                }

                // Simulate sending feedback (e.g., save to database or send via API)
                showThankYouMessage(name);

                // Clear fields after submission
                clearFields();
            }
        });
    }

    private void showThankYouMessage(String name) {
        // Thank you message after feedback submission
        String message = "ধন্যবাদ, " + name + "! আপনার মতামত গ্রহণ করা হয়েছে।";
        Toast.makeText(FeedbackActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void clearFields() {
        // Clear input fields after feedback submission
        etName.setText("");
        etFeedback.setText("");
    }
}
