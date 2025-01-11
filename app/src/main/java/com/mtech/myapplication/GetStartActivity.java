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

public class GetStartActivity extends AppCompatActivity {

    private Button btn_create,btn_already;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        btn_create = findViewById(R.id.btn_CreateAccount);
        btn_already = findViewById(R.id.btn_AlreadyAccount);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetStartActivity.this,CreateAccountActivity.class);
                startActivity(intent);

            }
        });

        btn_already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GetStartActivity.this,AlreadyCreateActivity.class);
                startActivity(intent);


            }
        });




    }
}