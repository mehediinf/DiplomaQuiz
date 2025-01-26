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

public class MCQActivity extends BaseActivity {

    private LinearLayout llAllSubject,llBangla, llEnglish, llMath, llBangladesh,llInternational,llGeneralScience,llMentalSkill,llComputer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqactivity);

// Toolbar setup
        setupToolbar("MCQ", true);

        // LinearLayout Initialization
        llAllSubject = findViewById(R.id.ll_AllSubject);
        llBangla = findViewById(R.id.ll_Bangla);
        llEnglish = findViewById(R.id.ll_English);
        llMath = findViewById(R.id.ll_Math);
        llBangladesh = findViewById(R.id.ll_BangladeshGK);
        llInternational = findViewById(R.id.ll_InternationalGlK);
        llGeneralScience = findViewById(R.id.ll_GeneralScience);
        llMentalSkill = findViewById(R.id.ll_Mentalskills);
        llComputer = findViewById(R.id.ll_Computer);


// Set click listeners with specific actions and messages
        setClickListener(llAllSubject, "সমস্ত বিষয়", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n  ৮০টি প্রশ্ন, ৮০ নম্বর, ৬০ মিনিট।", AllSubjectsQuizActivity.class);
        setClickListener(llBangla, "বাংলা", "আপনি কি বাংলা পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", BanglaQuizActivity.class);
        setClickListener(llEnglish, "ইংরেজি", "আপনি কি ইংরেজি পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", EnglishQuizActivity.class);
        setClickListener(llMath, "গণিত", "আপনি কি গণিত পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", MathQuizActivity.class);
        setClickListener(llBangladesh, "বাংলাদেশ", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", BangladeshQuizActivity.class);
        setClickListener(llInternational, "আন্তর্জাতিক", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", InternationalQuizActivity.class);
        setClickListener(llGeneralScience, "সাধারণ বিজ্ঞান", "আপনি কি সাধারণ বিজ্ঞান পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", GeneralScienceQuizActivity.class);
        setClickListener(llMentalSkill, "মানসিক দক্ষতা", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", MentalSkillQuizActivity.class);
        setClickListener(llComputer, "কম্পিউটার", "আপনি কি পরীক্ষা শুরু করতে চান?\n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।", ComputerQuizActivity.class);


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
            Intent intent = new Intent(MCQActivity.this, targetActivity);
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



    /*// সাধারণ ডায়ালগ তৈরি করার ফাংশন
    private void showDialog(String subject, Class<?> targetActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SingleQuizActivity.this);
        builder.setTitle(subject);
        builder.setMessage("আপনি কি " + subject + " কুইজ শুরু করতে চান? \n\n ২৫টি প্রশ্ন, ২৫ নম্বর, ২০ মিনিট।");

        builder.setPositiveButton("হ্যাঁ", (dialog, which) -> {
            // Intent দিয়ে লিঙ্কে (অন্য Activity) পাঠানো
            Intent intent = new Intent(SingleQuizActivity.this, targetActivity);
            startActivity(intent);
        });

        builder.setNegativeButton("না", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // প্রত্যেক LinearLayout-এর জন্য ক্লিক লিসেনার সেট করা
    private void setClickListener(LinearLayout layout, String subject, Class<?> targetActivity) {
        layout.setOnClickListener(view -> showDialog(subject, targetActivity));
    }*/





}