package com.myproject.fragmentdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment workoutDetailFragment=
                (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFrag);
      //  workoutDetailFragment.workoutId=0;
        int workoutId=(int)getIntent().getExtras().get("keyID");
        workoutDetailFragment.workoutId=workoutId;


    }
}
