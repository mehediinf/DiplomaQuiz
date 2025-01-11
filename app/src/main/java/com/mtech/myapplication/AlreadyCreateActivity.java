package com.mtech.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlreadyCreateActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private CheckBox cbRememberMe;
    private TextView forgotPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_create);

        // Toolbar setup
        setupToolbar();

        // Initialize views
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        forgotPassword = findViewById(R.id.forgotPassword);
        btnSignUp = findViewById(R.id.btn_SignUpId);

        // Set up listeners
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlreadyCreateActivity.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupToolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.create_account);
        }
    }

    private void handleSignUp() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean rememberMe = cbRememberMe.isChecked();

        if (email.isEmpty()) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Please enter your password");
            etPassword.requestFocus();
            return;
        }

        showSuccessDialog();

    }

    private void showSuccessDialog() {
        // Custom Dialog তৈরি
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_dialog_welcome_back);

        // ডায়ালগের আকার ঠিক করা
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // ডায়ালগ দেখানো
        dialog.show();
    }




}
