package com.example.bmicalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtHeightFt,edtHeightI;
        Button btm;
        TextView Result;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightI = findViewById(R.id.edtHeightI);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btm = findViewById(R.id.btm);
        Result = findViewById(R.id.result);

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int hI = Integer.parseInt(edtHeightI.getText().toString());
                int hft = Integer.parseInt(edtHeightFt.getText().toString());

                int totalIn = hft*12+hI;
                double totalCm= totalIn*2.53;
                double totalM= totalCm/100;
                double bmi=wt/(totalM*totalM);

                if(bmi>25){
                    Result.setText("You are over weight");
                }else if(bmi<18){
                    Result.setText("Under weight");
                }else Result.setText("You are fit");

            }
        });
    }
}