package com.example.tasklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declaring variables publically so they don't need to be passed into method
    EditText mass, height;
    Button calculate;
    TextView bmiResult, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining variables
        mass = findViewById(R.id.weightInput);
        height = findViewById(R.id.heightInput);
        calculate = findViewById(R.id.calculate);
        bmiResult = (TextView)findViewById(R.id.bmi);
        note = (TextView)findViewById(R.id.note);
    }

    @SuppressLint("SetTextI18n")
    public void onClick (View view) {
        double bmi = Double.parseDouble(mass.getText().toString()) / Math.pow(Double.parseDouble(height.getText().toString()), 2);
        bmiResult.setText("BMI: "+Math.round(bmi*100.0)/100.0);

        if (bmi < 18.5)
            note.setText("Your BMI indicates you are underweight");
        else if (bmi >= 18.5 && bmi <= 24.9)
            note.setText("Your BMI is indicates you are in the normal weight range");
        else if (bmi >= 25 && bmi <= 29.9)
            note.setText("Your BMI is indicates you are overweight");
        else
            note.setText("Your BMI is indicates you are obese");
    }
}