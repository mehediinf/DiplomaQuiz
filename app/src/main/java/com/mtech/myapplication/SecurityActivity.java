package com.mtech.myapplication;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecurityActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);


        // Toolbar setup
        setupToolbar("Security", true);

        TextView securityTextView = findViewById(R.id.securityTextView);
        securityTextView.setText(Html.fromHtml(getString(R.string.security_txt), Html.FROM_HTML_MODE_LEGACY));




    }
}