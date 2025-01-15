package com.mtech.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class CreateNewPasswordActivity extends BaseActivity {

    private Button btnCreContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password);


        // Toolbar setup
        setupToolbar("New Password", true);

        btnCreContinue = findViewById(R.id.btn_ContinuePassId);
        btnCreContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showSuccessDialog();


            }
        });


    }


    private void showSuccessDialog() {
        // Custom Dialog তৈরি
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.wel_come_back);

        // ডায়ালগের আকার ঠিক করা
        Objects.requireNonNull(dialog.getWindow()).setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // ডায়ালগ দেখানো
        dialog.show();


        Button btnHome = dialog.findViewById(R.id.btnHomeId);
        btnHome.setOnClickListener(view -> {
            // ডায়ালগ বন্ধ এবং MainActivity তে যাওয়া
            dialog.dismiss();
            Intent intent = new Intent(CreateNewPasswordActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });



    }




}