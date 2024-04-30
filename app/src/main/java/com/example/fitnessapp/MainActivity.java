package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv ;

    Button calories_calculator_Btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        calories_calculator_Btn= findViewById(R.id.calculatorBTN);


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


        calories_calculator_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOne = new Intent(MainActivity.this, Calculator_Activity.class);
                startActivity(intentOne);
            }
        });






    }
}