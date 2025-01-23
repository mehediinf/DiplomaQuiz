package com.mtech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudyActivity extends BaseActivity {


    LinearLayout llElectrical,llCivil,llMechanical,llComputer,llBangla,llMath,llEnglish,llGeneralScience,llMentalSkills,llRecent,llBangladesh,llInternatinal,llBacisComputer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        // Toolbar setup
        setupToolbar("Study", true);



        // Department LinearLayout
        llElectrical = findViewById(R.id.ll_Electrical);
        llCivil = findViewById(R.id.ll_Civil);
        llMechanical = findViewById(R.id.ll_Mechanical);
        llComputer = findViewById(R.id.ll_Computer);

        // Non-Department LinearLayout
        llRecent = findViewById(R.id.ll_Recent);
        llBangla = findViewById(R.id.ll_Bangla);
        llMath = findViewById(R.id.ll_Math);
        llEnglish = findViewById(R.id.ll_English);
        llGeneralScience = findViewById(R.id.ll_GeneralScience);
        llMentalSkills = findViewById(R.id.ll_Mentalskills);
        llBangladesh = findViewById(R.id.ll_BangladeshGK);
        llInternatinal = findViewById(R.id.ll_InternationalGlK);
        llBacisComputer = findViewById(R.id.ll_ComputerBasis);



        // Set click listeners for each department
        llElectrical.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this,ElectricalStudyActivity.class)));
        llCivil.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this,CivilStudyActivity.class)));
        llMechanical.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this,MechanicalStudyActivity.class)));
        llComputer.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this,ComputerStudyActivity.class)));



        // Set click listeners for each non-department
        llRecent.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, RecentStudyActivity.class)));
        llBangla.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, BanglaStudyActivity.class)));
        llMath.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, MathStudyActivity.class)));
        llEnglish.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, EnglishStudyActivity.class)));
        llGeneralScience.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, GeneralScienceStudyActivity.class)));
        llMentalSkills.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, MentalSkillsStudyActivity.class)));
        llBangladesh.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, BangladeshStudyActivity.class)));
        llInternatinal.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, InternatinalStudyActivity.class)));
        llBacisComputer.setOnClickListener(v -> startActivity(new Intent(StudyActivity.this, BacisComputerStudyActivity.class)));



    }
}