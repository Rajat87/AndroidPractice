package com.myproject.employee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerPersonAdapter extends RecyclerView.Adapter<RecyclerPersonAdapter.ViewHolder> {
    Context context;//Context of the RecyclerDemoActivity Activity
    int resource;//Layout File Reference of the list item
    ArrayList<Person> arrayList;//Array List consisting of Person Objects
    OnPersonClickListener mOnPersonClickListener; //Global OnPersonClickListener reference

    public RecyclerPersonAdapter(Context context, int resource, ArrayList<Person> arrayList,OnPersonClickListener onPersonClickListener) {
        this.context = context;
        this.resource = resource;
        this.arrayList = arrayList;
        this.mOnPersonClickListener=onPersonClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(context).inflate(resource,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view,mOnPersonClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person person=arrayList.get(position);
        viewHolder.textView1.setText(person.name);
        viewHolder.textView2.setText(person.birthday);
        viewHolder.textView3.setText(person.gender);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        OnPersonClickListener onPersonClickListener;

        public ViewHolder(@NonNull View itemView,OnPersonClickListener onPersonClickListener) {
            super(itemView);
             textView1=itemView.findViewById(R.id.textView1);
             textView2=itemView.findViewById(R.id.textView2);
             textView3=itemView.findViewById(R.id.textView3);
             this.onPersonClickListener=onPersonClickListener;
             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPersonClickListener.onPersonClick(getAdapterPosition());//On calling the on person click of RecyclerDemoActivity This Gives the position of the list item in recycler view

        }
    }
    interface OnPersonClickListener{
        void onPersonClick(int position);
    }

}
