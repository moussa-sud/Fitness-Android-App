package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator_Activity extends AppCompatActivity {
    private EditText editTextAge, editTextWeight, editTextHeight;
    private RadioGroup radioGroupGender;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set onClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });
    }

    private void calculateCalories() {

        String ageText = editTextAge.getText().toString();
        String weightText = editTextWeight.getText().toString();
        String heightText = editTextHeight.getText().toString();
        int genderId = radioGroupGender.getCheckedRadioButtonId();

        // if the user doesn't enter anything
        if (ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty()) {
            textViewResult.setText("Please fill in all fields.");
            return;
        }

        int age = Integer.parseInt(ageText);
        double weight = Double.parseDouble(weightText);
        double height = Double.parseDouble(heightText);
        String gender = (genderId == R.id.Male) ? "male" : "female";

        // Calculate the daily calories needed
        double Needed_calories;
        if (gender.equals("male")) {
            Needed_calories = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            Needed_calories = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

// Needed_calories to display only the decimal part
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedCalories = decimalFormat.format(Needed_calories);



        String resultMessage = "Your body's baseline calorie needs is approximately: " + formattedCalories + " calories";

        textViewResult.setText(resultMessage);


    }

}