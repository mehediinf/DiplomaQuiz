package com.mtech.myapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private TextView tvPrsonal, tvFaq, tvContact, tvShareApp, tvRating,tvFeedback,tvAbout,tvLogout;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Initialize views
        tvPrsonal = view.findViewById(R.id.tv_ParsonalInfo);
        tvFaq = view.findViewById(R.id.tv_FAQ);
        tvContact = view.findViewById(R.id.tv_ContactUs);
        tvShareApp = view.findViewById(R.id.tv_ShareApp);
        tvRating = view.findViewById(R.id.tv_AppRating);
        tvFeedback = view.findViewById(R.id.tv_Feedback);
        
        tvAbout = view.findViewById(R.id.tv_About);
        tvLogout = view.findViewById(R.id.tv_Logout);

        // Set click listeners
        setMenuItemClickListeners();

        return view;
    }

    private void setMenuItemClickListeners() {
        tvPrsonal.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
            startActivity(intent);
        });

        tvFaq.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FAQActivity.class);
            startActivity(intent);
        });

        tvContact.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ContactUsActivity.class);
            startActivity(intent);
        });

        tvShareApp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "DiplomaQuiz অ্যাপটি ব্যবহার করে দেখুন!";
            String body = "প্রিয়,\n\nআমি একটি চমৎকার অ্যাপ পেয়েছি যার নাম DiplomaQuiz। এটি ডিপ্লোমা পরীক্ষার প্রস্তুতির জন্য অসাধারণ। এখানে বিভিন্ন ধরনের কুইজ এবং রিসোর্স রয়েছে যা শিক্ষার্থীদের সহায়তা করবে।\n\nএখনই ডাউনলোড করুন Google Play Store থেকে:\nhttps://play.google.com/store/apps/details?id= getPackageName()" + "\n\nশুভ শিক্ষার পথে অগ্রসর হোন!";


            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"Share with"));




        });

        tvRating.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HelpCenterActivity.class);
            startActivity(intent);
        });

        tvFeedback.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FeedbackActivity.class);
            startActivity(intent);
        });
        

        tvAbout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        });

        tvLogout.setOnClickListener(v -> {
            showLogoutDialog();
        });
    }

    private void showLogoutDialog() {
        Dialog dialog = new Dialog(requireContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.logout_dialoge);

        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        Button logoutButton = dialog.findViewById(R.id.logoutButton);

        cancelButton.setOnClickListener(v -> dialog.dismiss());

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), GetStartActivity.class);
            startActivity(intent);

            dialog.dismiss();
            if (getActivity() != null) {
                Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });

        dialog.show();
    }

}

