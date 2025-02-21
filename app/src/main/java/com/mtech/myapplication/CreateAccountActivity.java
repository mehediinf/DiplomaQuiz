package com.mtech.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.Dialog;
import android.view.Window;


public class CreateAccountActivity extends BaseActivity {

    private EditText etUsername, etEmail, etPassword;
    private CheckBox cbRememberMe;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        setupToolbar("Create Account", true);

        showSuccessDialog();
    }

    private void showSuccessDialog() {
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

//ProgressBar Time Set ...............

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(CreateAccountActivity.this,HomePageActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },2500);



    }



}
