package com.mtech.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DepartmentActivity extends BaseActivity {

    LinearLayout llElectrical,llCivil,llMechanical,llComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        // Toolbar setup
        setupToolbar("Department Exam", true);


        // Department LinearLayout
        llElectrical = findViewById(R.id.ll_ElectricalExam);
        llCivil = findViewById(R.id.ll_CivilExam);
        llMechanical = findViewById(R.id.ll_MechanicalExam);
        llComputer = findViewById(R.id.ll_ComputerExam);


 // Set click listeners for each department
        setClickListener(llElectrical, "ইলেকট্রিক্যাল", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n  ২০টি প্রশ্ন, ২০ নম্বর, ২০ মিনিট।", AllSubjectsQuizActivity.class);
        setClickListener(llCivil, "সিভিল", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২০টি প্রশ্ন, ২০ নম্বর, ২০ মিনিট।", BanglaQuizActivity.class);
        setClickListener(llMechanical, "মেকানিক্যাল", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২০টি প্রশ্ন, ২০ নম্বর, ২০ মিনিট।", EnglishQuizActivity.class);
        setClickListener(llComputer, "কম্পিউটার", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২০টি প্রশ্ন, ২০ নম্বর, ২০ মিনিট।", MathQuizActivity.class);

    }

    // কাস্টম ডায়ালগ প্রদর্শনের ফাংশন
    private void showCustomDialog(String subject, String message, Class<?> targetActivity) {
        // Dialog ইনস্ট্যান্স তৈরি
        Dialog dialog = new Dialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.subject_custom_dialog_layout, null);
        dialog.setContentView(view);

        // ডায়ালগের ভিউগুলোর রেফারেন্স
        TextView tvDialogTitle = view.findViewById(R.id.tvDialogTitle);
        TextView tvDialogMessage = view.findViewById(R.id.tvDialogMessage);
        TextView btnYes = view.findViewById(R.id.btnYes);
        TextView btnNo = view.findViewById(R.id.btnNo);

        // টাইটেল এবং বার্তা সেট করা
        tvDialogTitle.setText(subject);
        tvDialogMessage.setText(message);

        // "হ্যাঁ" বাটনের ক্লিক ইভেন্ট
        btnYes.setOnClickListener(v -> {
            // Intent দিয়ে অন্য Activity-তে যাওয়া
            Intent intent = new Intent(DepartmentActivity.this, targetActivity);
            startActivity(intent);
            dialog.dismiss();
        });

        // "না" বাটনের ক্লিক ইভেন্ট
        btnNo.setOnClickListener(v -> dialog.dismiss());

        // ডায়ালগ প্রদর্শন
        dialog.show();
    }

    // প্রত্যেক LinearLayout-এর জন্য ক্লিক লিসেনার সেট করা
    private void setClickListener(LinearLayout layout, String subject, String message, Class<?> targetActivity) {
        layout.setOnClickListener(view -> showCustomDialog(subject, message, targetActivity));
    }







}