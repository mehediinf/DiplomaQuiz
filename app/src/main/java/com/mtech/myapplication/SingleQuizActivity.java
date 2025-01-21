package com.mtech.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SingleQuizActivity extends BaseActivity {


    private LinearLayout llBangla,llEnglish,llMath,llGenKnow,llAllSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_quiz);


        // Toolbar setup
        setupToolbar("Quiz", true);


        llBangla = findViewById(R.id.ll_Bangla);
        llEnglish = findViewById(R.id.ll_English);
        llMath = findViewById(R.id.ll_Math);
        llGenKnow = findViewById(R.id.ll_GeneralKnowledge);
        llAllSubject = findViewById(R.id.ll_AllSubject);






    }
}