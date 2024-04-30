package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);


        ArrayList<Information> information = new ArrayList<>();

        information.add(new Information("Chest" , R.drawable.chest_0));

        information.add(new Information("Upper Back", R.drawable.upperback0));

        information.add(new Information("Triceps", R.drawable.triceps0));

        information.add(new Information("Biceps" , R.drawable.biceps_0));



        RecyclerViewProduct RecyclerAdapter = new RecyclerViewProduct(MainActivity.this, information);

        rv.setAdapter(RecyclerAdapter);
        rv.hasFixedSize();




        // layout for vertical orientation

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);






    }
}