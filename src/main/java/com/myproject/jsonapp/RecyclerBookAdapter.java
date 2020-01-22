package com.myproject.jsonapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerBookAdapter extends RecyclerView.Adapter<RecyclerBookAdapter.ViewHolder>  {
    Context context;//Context of the Test Activity
    int resource;//Layout File Reference of the list item
    ArrayList<Book> bookArrayList;//Array List consisting of Person Objects
    OnBookClickListener onBookClickListener;

    public RecyclerBookAdapter(Context context, int resource, ArrayList<Book> bookArrayList,OnBookClickListener onBookClickListener) {
        this.context = context;
        this.resource = resource;
        this.bookArrayList = bookArrayList;
        this.onBookClickListener=onBookClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(resource,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view,onBookClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Book book=bookArrayList.get(i);
        viewHolder.textViewName.setText(book.name);
        viewHolder.textViewPrice.setText(book.price);
        viewHolder.textViewAuthor.setText(book.author);
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewAuthor;
        TextView textViewPrice;
        OnBookClickListener onBookClickListener;
        public ViewHolder(@NonNull View itemView,OnBookClickListener onBookClickListener) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewAuthor=itemView.findViewById(R.id.textViewAuthor);
            textViewPrice=itemView.findViewById(R.id.textViewPrice);
            this.onBookClickListener=onBookClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onBookClickListener.onBookClick(getAdapterPosition());//This Gives the position of the list item in recycler view to the Test Activity
        }
    }

    interface OnBookClickListener{
        void onBookClick(int position);
    }
}
