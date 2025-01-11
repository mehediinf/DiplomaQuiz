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

public class dialog_welcome_back extends AppCompatActivity {

    private Button btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_welcome_back);

        btnHome = findViewById(R.id.btn_Home);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {`

                Intent intent = new Intent(dialog_welcome_back.this,HomePageActivity.class);
                startActivity(intent);
                finish();


            }
        });










    }
}