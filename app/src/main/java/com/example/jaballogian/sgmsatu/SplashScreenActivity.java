package com.example.jaballogian.sgmsatu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import me.anwarshahriar.calligrapher.Calligrapher;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIMED_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

//        Calligrapher calligrapher = new Calligrapher(this);
//        calligrapher.setFont(this, "PRODUCT_SANS.ttf", true);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent toMainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                toMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toMainActivity);
                finish();
            }
        },SPLASH_TIMED_OUT);
    }
}
