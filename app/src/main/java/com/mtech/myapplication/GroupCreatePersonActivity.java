package com.mtech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GroupCreatePersonActivity extends BaseActivity {


    private RadioGroup btnGroupRadio;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create_person);


        // Toolbar setup
        setupToolbar("Group Create", true);


        btnGroupRadio = findViewById(R.id.btnGroupRadio);
        btnNext = findViewById(R.id.btnNext);

        // "Next" বাটনে ক্লিক ইভেন্ট হ্যান্ডলার
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // রেডিও গ্রুপ থেকে সিলেক্ট করা রেডিও বাটনের আইডি পাওয়া
                int selectedId = btnGroupRadio.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    // সিলেক্ট করা রেডিও বাটন খুঁজে বের করা
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();

                    // সিলেক্ট করা অপশনের ভিত্তিতে টোস্ট দেখানো
                    startActivity(new Intent(GroupCreatePersonActivity.this, CreateGroup2ndActivity.class));
                } else {
                    // যদি কিছুই সিলেক্ট না করা হয়
                    Toast.makeText(GroupCreatePersonActivity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}