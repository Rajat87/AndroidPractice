package com.myproject.fragmentdemoapp;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {
    //Button buttonShowDetails;
    void initViews(){
        //buttonShowDetails=findViewById(R.id.buttonShowDetails);
       // buttonShowDetails.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id) {
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("keyID",(int)id);
        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    //  @Override
    /*public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonShowDetails:
                Intent intent=new Intent(this,DetailActivity.class);
                startActivity(intent);
        }
    }*/
}
