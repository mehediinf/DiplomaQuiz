package com.mtech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateNewPasswordActivity extends BaseActivity {

    private Button btnCreContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password);


        // Toolbar setup
        setupToolbar("Forgot Password", true);

        btnCreContinue = findViewById(R.id.btn_ContinuePassId);
        btnCreContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CreateNewPasswordActivity.this,)


            }
        });







    }
}