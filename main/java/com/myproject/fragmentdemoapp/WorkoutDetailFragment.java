package com.myproject.fragmentdemoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        if (view!=null){
            TextView textTitle=view.findViewById(R.id.textTitle);
            Workout workout=Workout.workouts[(int) workoutId];//This basically means workout=Workout.workouts[0]
            textTitle.setText(workout.getName());
            TextView textDescription=view.findViewById(R.id.textDescription);
            textDescription.setText(workout.getDescription());
        }

    }
}
