package com.myproject.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView myListView;
    void initViews(){
        myListView=findViewById(R.id.myListView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();
      /*  ArrayList<String> arrayList=new ArrayList();
        arrayList.add("Jim");
        arrayList.add("Jennie");
        arrayList.add("Jack");
        arrayList.add("Joe");
        arrayList.add("James");  */

       // ArrayAdapter adapter=new ArrayAdapter(this,R.layout.simple_list_item,arrayList); //ArrayAdapter can display only one view in a list item
      //  myListView.setAdapter(adapter);//That is why we need to create our own listAdapter to insert multiple views in a list item

      //Custom List View using custom ArrayAdapter
        final ArrayList<Person> arrayList=new ArrayList();
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

        PersonListAdapter personListAdapter=new PersonListAdapter(this,R.layout.simple_list_item_2,arrayList);
        myListView.setAdapter(personListAdapter);
        //Click Listener for List View
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),""+arrayList.get(position),Toast.LENGTH_LONG).show();
                //Code to get the value of a view from the list item
                TextView sample=view.findViewById(R.id.textView1);
                String value=sample.getText().toString();
            }
        });

    }
}
