package com.myproject.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button switchButton ;
    void initViews(){
         imageView=findViewById(R.id.firstImage);
         switchButton=findViewById(R.id.switchActivityButton);
         imageView.setOnClickListener(this);
         switchButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //Can be done by three ways

       /* 1. int imageResource=getResources().getIdentifier("@drawable/wimbledon",null,this.getPackageName());
        imageView.setImageResource(imageResource);*/
       //2
       imageView.setImageResource(R.drawable.wimbledon);
       //3 Using src compat in xml

    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        if (id==R.id.firstImage){
            Toast.makeText(MainActivity.this,"Image Clicked!!",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.switchActivityButton){
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{

        }
    }
}
