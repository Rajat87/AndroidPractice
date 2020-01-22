package com.myproject.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerDemoActivity extends AppCompatActivity implements RecyclerPersonAdapter.OnPersonClickListener {
    //RecyclerDemoActivity is a OnPersonClickListener
    //RecyclerDemoActivity's object's reference is passed in the RecyclerPersonAdapter Constructor such that it lands in the mOnPersonClickListener reference
    RecyclerPersonAdapter recyclerPersonAdapter;
    RecyclerView recyclerView;
    void initViews(){
     recyclerView=findViewById(R.id.recyclerView);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        initViews();
        ArrayList<Person> arrayList=new ArrayList();
        Person john=new Person("John","11-01-2051","Male");
        Person jennie=new Person("Jennie","12-01-2051","Female");
        Person jim=new Person("jim","11-01-2051","Male");
        Person jack=new Person("jack","11-01-2051","Male");
        Person joe=new Person("John","11-01-2051","Male");
        Person james=new Person("james","11-01-2051","Male");
        Person james0=new Person("james0","11-01-2051","Male");
        Person james1=new Person("james1","11-01-2051","Male");
        Person james2=new Person("james2","11-01-2051","Male");
        Person james3=new Person("james3","11-01-2051","Male");
        Person james4=new Person("james4","11-01-2051","Male");
        Person james5=new Person("james5","11-01-2051","Male");
        Person james6=new Person("james6","11-01-2051","Male");
        Person james7=new Person("james7","11-01-2051","Male");
        Person james8=new Person("james8","11-01-2051","Male");
        Person james9=new Person("james9","11-01-2051","Male");
        arrayList.add(john);
        arrayList.add(jennie);
        arrayList.add(jim);
        arrayList.add(jack);
        arrayList.add(joe);
        arrayList.add(james);
        arrayList.add(james0);
        arrayList.add(james1);
        arrayList.add(james2);
        arrayList.add(james3);
        arrayList.add(james4);
        arrayList.add(james5);
        arrayList.add(james6);
        arrayList.add(james7);
        arrayList.add(james8);
        arrayList.add(james9);
        //Polymorphic statement
       // RecyclerPersonAdapter.OnPersonClickListener ref=new RecyclerDemoActivity(); //This reference is passed using this keyword
        recyclerPersonAdapter=new RecyclerPersonAdapter(this,R.layout.simple_list_item_2,arrayList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerPersonAdapter);

    }


    @Override
    public void onPersonClick(int position) {
        Toast.makeText(this,""+position,Toast.LENGTH_LONG).show();
    }
}
