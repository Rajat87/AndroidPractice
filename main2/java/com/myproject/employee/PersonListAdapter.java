package com.myproject.employee;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonListAdapter extends ArrayAdapter<Person> {
    Context context;//Reference to activity
    int resource;//Reference to XML file
    List<Person> objects;//Reference to ArrayList
    public PersonListAdapter( Context context, int resource , List<Person> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

// getView method shall execute n number of times from 0 ton n-1
// n is the size of the array list
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        //convertView should point to ListItem
        //inflate method is used to read the XML file
        View view;
        view= LayoutInflater.from(context).inflate(resource,parent,false);
        //Accessing different views in my XML file by reading it using inflate function
        TextView textView1=view.findViewById(R.id.textView1);
        TextView textView2=view.findViewById(R.id.textView2);
        TextView textView3=view.findViewById(R.id.textView3);

        Person person=objects.get(position);//Get the object from the list on the basis of index
        textView1.setText(person.name);
        textView2.setText(person.birthday);
        textView3.setText(person.gender);
        return view;
    }
}
