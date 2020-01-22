package com.myproject.jsonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
   // String testPrice="";
    TextView textViewAuthor2,textViewName2;
    void initViews(){
        textViewAuthor2=findViewById(R.id.textViewAuthor2);
        textViewName2=findViewById(R.id.textViewName2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        Book book=(Book) getIntent().getSerializableExtra("ObjectData");
        textViewName2.setText(book.name);
        textViewAuthor2.setText(book.author);
        /*ArrayList<Book> bookArrayList =(ArrayList<Book>) getIntent().getSerializableExtra("sampleData");
        Book book=bookArrayList.get(0);
        Book book1=bookArrayList.get(1);
        Book book2=bookArrayList.get(2);

        if (testPrice==book.price){
            textViewAuthor2.setText(book.author);
            textViewName2.setText(book.name);

        }else if (testPrice==book1.price){
            textViewAuthor2.setText(book1.author);
            textViewName2.setText(book1.name);
        }else {
            textViewAuthor2.setText(book2.author);
            textViewName2.setText(book2.name);
        }*/


    }
}
