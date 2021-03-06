package com.myproject.jsonapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    TextView textViewSplash;
    void initViews(){
         //getSupportActionBar().hide();
         textViewSplash=findViewById(R.id.textViewSplash);
         Animation animation= AnimationUtils.loadAnimation(this,R.anim.alpha);
         textViewSplash.startAnimation(animation);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
        handler.sendEmptyMessageDelayed(101,3000);
       // Toast.makeText(this,"Splash Created",Toast.LENGTH_LONG).show();
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 101){
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
}
