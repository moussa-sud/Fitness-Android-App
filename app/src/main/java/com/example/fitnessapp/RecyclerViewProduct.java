package com.example.fitnessapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewProduct extends RecyclerView.Adapter<viewHolder> {


    // for the first thing we initialize the the ArrayList Object in other to use it in
    // onBindViewHolder

    ArrayList<Information> db  ;
    Context context ; //  The Context in which this LayoutInflater will create its Views

    public RecyclerViewProduct (Context context , ArrayList<Information> data ){
        db = data ;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();



        /// retrieve a standard LayoutInflater instance


        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        return new viewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull viewHolder viewholder, int position) {
        Information information = db.get(position);

        // here we're  calling all our data from the product class


        viewholder.Name.setText(information.getName());

        viewholder.image.setImageResource(information.getImage());


        // we use this function to open the new page when the view holder is open

        viewholder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        // Start ActivityOne
                        Intent intentOne = new Intent(context, chestActivity.class);
                        context.startActivity(intentOne);
                        break;

                    case 1:
                        // Start ActivityOne
                        Intent intentTwo = new Intent(context, UpperbackActivity.class);
                        context.startActivity(intentTwo);
                        break;

                    case 2:
                        // Start ActivityOne
                        Intent intentthree = new Intent(context, TricepsActivity.class);
                        context.startActivity(intentthree);
                        break;

                    case 3:
                        // Start ActivityOne
                        Intent intentfour = new Intent(context, bicepsActivity.class);
                        context.startActivity(intentfour);
                        break;


                    default:
                        // If no specific activity is defined for this position, do nothing
                        break;
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return db.size();
    }








}