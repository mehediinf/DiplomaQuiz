package com.mtech.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        /// Toolbar setup
        setupToolbar("Developer", true);

// Retrieve the string array from resources
        String[] contactInfo = getResources().getStringArray(R.array.developer_contact_info);

// Display the contact information in a loop
        for (String info : contactInfo) {
            Log.d("ContactInfo", info);
        }







    }
}
