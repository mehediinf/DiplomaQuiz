package com.mtech.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class GroupJoinActivity extends BaseActivity {

    private EditText edtJoinCode;
    private Button btnGroupJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_join);

        // Toolbar setup
        setupToolbar("Join Group", true);

        // Initialize views
        edtJoinCode = findViewById(R.id.edtJoinCode);
        btnGroupJoin = findViewById(R.id.btnGroupJoin);

        // Join button click listener
        btnGroupJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String joinCode = edtJoinCode.getText().toString().trim();
                if (joinCode.isEmpty()) {
                    Toast.makeText(GroupJoinActivity.this, "Please enter a join code!", Toast.LENGTH_SHORT).show();
                } else {
                    showSuccessDialog();
                }
            }
        });
    }

    /*// Method to show the waiting dialog
    private void showWaitingDialog() {
        // Create the dialog
        Dialog waitingDialog = new Dialog(this);
        waitingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Hide default title
        waitingDialog.setContentView(R.layout.logout_dialoge); // Set custom dialog layout
        waitingDialog.setCancelable(false); // Disable outside touch to cancel

        // Set up dialog views (optional, if you need to update ProgressBar or TextView)
        ProgressBar progressBar = waitingDialog.findViewById(R.id.progressGroupJoin);
      //  TextView waitingText = waitingDialog.findViewById(R.id.textWaiting);

        // Show the dialog
        waitingDialog.show();

        // Optional: Close the dialog after some time (simulating admin response)
        waitingDialog.findViewById(R.id.progressGroupJoin).postDelayed(() -> {
            Toast.makeText(GroupJoinActivity.this, "Admin clicked start!", Toast.LENGTH_SHORT).show();
            waitingDialog.dismiss(); // Close the dialog
        }, 5000); // Simulates a 5-second wait
    }*/


    private boolean showSuccessDialog() {
        // Custom Dialog তৈরি
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.join_dialoge);

        // ডায়ালগের আকার ঠিক করা
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // ডায়ালগ দেখানো
        dialog.show();


        // Optional: Close the dialog after some time (simulating admin response)
        dialog.findViewById(R.id.progressGroupJoin).postDelayed(() -> {
            Toast.makeText(GroupJoinActivity.this, "Admin clicked start!", Toast.LENGTH_SHORT).show();
            dialog.dismiss(); // Close the dialog
        }, 5000);


        return true;
    }












}
