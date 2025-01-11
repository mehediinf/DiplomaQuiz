package com.mtech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imgDotsLoader1, imgDotsLoader2, imgDotsLoader3;
    AnimationDrawable animationDrawable1, animationDrawable2, animationDrawable3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // ডট লোডার ImageView সেট করা
        imgDotsLoader1 = findViewById(R.id.dots_loader1);
        imgDotsLoader2 = findViewById(R.id.dots_loader2);
        imgDotsLoader3 = findViewById(R.id.dots_loader3);

        // AnimationDrawable সেট করা
        animationDrawable1 = (AnimationDrawable) imgDotsLoader1.getDrawable();
        animationDrawable2 = (AnimationDrawable) imgDotsLoader2.getDrawable();
        animationDrawable3 = (AnimationDrawable) imgDotsLoader3.getDrawable();

        // অ্যানিমেশন শুরু করা
        animationDrawable1.start();
        animationDrawable2.start();
        animationDrawable3.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,GetStartActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);


    }
}
