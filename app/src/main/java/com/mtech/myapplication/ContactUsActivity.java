package com.mtech.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class ContactUsActivity extends BaseActivity {

    private TextView tvHelpCenter,tvWhatsapp,tvFacebook,tvTelegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Toolbar setup
        setupToolbar("Contact Us", true);

        tvHelpCenter = findViewById(R.id.tv_HelpCenter);
        tvWhatsapp = findViewById(R.id.tv_WhatsApp);
        tvFacebook = findViewById(R.id.tv_Facebook);
        tvTelegram = findViewById(R.id.tv_Telegram);


        tvHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the link in the browser
                Intent intent = new Intent(ContactUsActivity.this, HelpCenterActivity.class);
                startActivity(intent);
            }
        });

        tvWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the link in the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                startActivity(browserIntent);
            }
        });

        tvFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the link in the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=61571949731080"));
                startActivity(browserIntent);
            }
        });

        tvTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open the link in the browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/+h6sh54Y7YI5mOWU1"));
                startActivity(browserIntent);
            }
        });






    }
}