package com.mtech.myapplication;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelpCenterActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        // Toolbar setup
        setupToolbar("Help Center", true);

        TextView helpTextView = findViewById(R.id.helpTextView);
        helpTextView.setText(Html.fromHtml(getString(R.string.help_center_txt), Html.FROM_HTML_MODE_LEGACY));








    }
}