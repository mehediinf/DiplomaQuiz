package com.mtech.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class GroupExamActivity extends BaseActivity {


    LinearLayout llCreateGroup,llJoinGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_exam);


        // Toolbar setup
        setupToolbar("Group Exam", true);

        llCreateGroup =findViewById(R.id.ll_CreateGroup);
        llJoinGroup =findViewById(R.id.ll_JoinGroup);



        // Set up listeners
        llCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GroupExamActivity.this,GroupCreatePersonActivity.class);
                startActivity(intent);




               // handleSignIn();
            }
        });


        llJoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GroupExamActivity.this,GroupJoinActivity.class);
                startActivity(intent);


            }
        });


    }

   // private void handleSignIn() {


     /*   String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean rememberMe = cbRememberMe.isChecked();

        if (email.isEmpty()) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Please enter your password");
            etPassword.requestFocus();
            return;
        }
*/



       /* if (showSuccessDialog()){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GroupExamActivity.this,GroupCreatePersonActivity.class);
                    startActivity(intent);
                }
            },500);

        }*/




   // }
/*

    private boolean showSuccessDialog() {
        // Custom Dialog তৈরি
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_success);

        // ডায়ালগের আকার ঠিক করা
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // ডায়ালগ দেখানো
        dialog.show();
        return true;
    }
*/




}