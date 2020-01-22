package com.myproject.fragmentdemoapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    Listener listener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] names=new String[Workout.workouts.length];
        for (int i=0;i<names.length;i++){
           // names[i]=Workout.workouts[(int)new WorkoutDetailFragment().workoutId].getName();
            names[i]=Workout.workouts[i].getName();
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(inflater.getContext(),R.layout.support_simple_spinner_dropdown_item,names);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener=(Listener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
            if (listener!=null){
                //Listener has reference to MainActivity
                listener.itemClicked(id);//This calls MainActivity’s itemClicked() method, passing it the ID of the workout that was clicked,
            }
    }

    //An interface can be used to send data from the fragment to the activity
    public interface Listener{
        void itemClicked(long id);
    }


}
