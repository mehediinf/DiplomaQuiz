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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private LinearLayout personalInfoLayout, securityLayout, helpCenterLayout, aboutLayout, logoutLayout;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Initialize views
        personalInfoLayout = view.findViewById(R.id.tv_ParsonalInfo);
        securityLayout = view.findViewById(R.id.tv_Security);
        helpCenterLayout = view.findViewById(R.id.tv_HelpCenter);
        aboutLayout = view.findViewById(R.id.tv_About);
        logoutLayout = view.findViewById(R.id.tv_Logout);

        // Set click listeners
        setMenuItemClickListeners();

        return view;
    }

    private void setMenuItemClickListeners() {
        personalInfoLayout.setOnClickListener(v -> navigateToActivity(PersonalInfoActivity.class, "Navigating to Personal Info"));
        securityLayout.setOnClickListener(v -> navigateToActivity(SecurityActivity.class, "Navigating to Security"));
        helpCenterLayout.setOnClickListener(v -> navigateToActivity(HelpCenterActivity.class, "Navigating to Help Center"));
        aboutLayout.setOnClickListener(v -> navigateToActivity(AboutActivity.class, "Navigating to About"));
        logoutLayout.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Logging Out", Toast.LENGTH_SHORT).show();
            showLogoutDialog();
        });
    }

    private void navigateToActivity(Class<?> activityClass, String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
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

        dialog.show();

        // Close the activity after showing the dialog
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}  