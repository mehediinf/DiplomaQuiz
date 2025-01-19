package com.mtech.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;

import java.util.Calendar;

public class PersonalInfoActivity extends BaseActivity {

    private EditText edtFullName, edtEmail, edtPhoneNumber, edtDateOfBirth;
    private Spinner spinnerGender;
    private ImageView profilePicture, editButton, calendarIcon;
    private Button btnUpdate;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        // Toolbar setup
        setupToolbar("Personal Info", true);

        // Initialize views
        initializeViews();

        // Set listeners
        setListeners();
    }

    /**
     * Initializes all views used in the activity.
     */
    private void initializeViews() {
        edtFullName = findViewById(R.id.edt_FullName);
        edtEmail = findViewById(R.id.edt_Email);
        edtPhoneNumber = findViewById(R.id.edt_PhoneNumber);
        edtDateOfBirth = findViewById(R.id.edt_DateOfBirth);
        spinnerGender = findViewById(R.id.Spinner_Gender);
        profilePicture = findViewById(R.id.profile_picture);
        editButton = findViewById(R.id.imgView_ImageEdt);
        calendarIcon = findViewById(R.id.imgView_DateMonth);
        btnUpdate = findViewById(R.id.btn_Update);
    }

    /**
     * Sets up event listeners for user interactions.
     */
    private void setListeners() {
        // Edit profile picture button click
        editButton.setOnClickListener(v -> openGallery());

        // Calendar icon click
        calendarIcon.setOnClickListener(v -> showDatePicker());

        // Update button click
        btnUpdate.setOnClickListener(v -> validateAndSubmitData());
    }

    /**
     * Opens the device gallery to choose a profile picture.
     */
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 100); // 100 is the request code
    }

    /**
     * Shows a date picker dialog for selecting the date of birth.
     */
    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
            edtDateOfBirth.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }

    /**
     * Validates input fields and handles form submission.
     */
    private void validateAndSubmitData() {
        String fullName = edtFullName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phoneNumber = edtPhoneNumber.getText().toString().trim();
        String dateOfBirth = edtDateOfBirth.getText().toString().trim();

        if (fullName.isEmpty()) {
            edtFullName.setError("Full name is required");
            edtFullName.requestFocus();
            return;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Enter a valid email address");
            edtEmail.requestFocus();
            return;
        }

        if (phoneNumber.isEmpty() || phoneNumber.length() < 10) {
            edtPhoneNumber.setError("Enter a valid phone number");
            edtPhoneNumber.requestFocus();
            return;
        }

        if (dateOfBirth.isEmpty()) {
            edtDateOfBirth.setError("Date of birth is required");
            edtDateOfBirth.requestFocus();
            return;
        }

        // Data submission successful
        Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            // Use Glide to load the image as a circular image
            Glide.with(this)
                    .load(selectedImageUri)
                    .circleCrop() // Ensures the image is circular
                    .into(profilePicture);
        }
    }
}
