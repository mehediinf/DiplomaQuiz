package com.mtech.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends BaseActivity {

    TextView tvDeveloper,tvPrivacyPolicy,tvTermCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Toolbar setup
        setupToolbar("About", true);

        // Find views
        tvDeveloper = findViewById(R.id.tv_Developer);
        tvPrivacyPolicy = findViewById(R.id.tv_PrivacyPolicy);
        tvTermCondition = findViewById(R.id.tv_TermCondition);


        tvDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AboutActivity.this,DeveloperActivity.class);
                startActivity(intent);

            }
        });

        tvPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the link in the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mehediinf"));
                startActivity(browserIntent);
            }
        });

        tvTermCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the link in the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mehediinf"));
                startActivity(browserIntent);
            }
        });




    }
}
