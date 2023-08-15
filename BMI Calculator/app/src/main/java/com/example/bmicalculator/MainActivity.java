package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editWeight,editHeightFt;
        Button btnCalculate;
        TextView textResult;
        LinearLayout linearLayout_bg;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);

        btnCalculate = findViewById(R.id.btnCalculate);

        textResult = findViewById(R.id.textResult);
        linearLayout_bg = findViewById(R.id.linearLayout_bg);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                float ft = Float.parseFloat(editHeightFt.getText().toString());


                float totalIn = ft*12;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi > 25){
                    textResult.setText("You are over Weight ...");
                    editWeight.setTextColor(getResources().getColor(R.color.black));
                    editHeightFt.setTextColor(getResources().getColor(R.color.black));
                    textResult.setTextColor(getResources().getColor(R.color.black));
                    linearLayout_bg.setBackgroundColor(getResources().getColor(R.color.over_wt));

                } else if (bmi<18) {
                    textResult.setText("You are Under Weight ...");
                    editWeight.setTextColor(getResources().getColor(R.color.black));
                    editHeightFt.setTextColor(getResources().getColor(R.color.black));
                    textResult.setTextColor(getResources().getColor(R.color.black));
                    linearLayout_bg.setBackgroundColor(getResources().getColor(R.color.under_wt));
                }else {
                    textResult.setText("You are healthy ...");
                    editWeight.setTextColor(getResources().getColor(R.color.black));
                    editHeightFt.setTextColor(getResources().getColor(R.color.black));
                    textResult.setTextColor(getResources().getColor(R.color.black));
                    linearLayout_bg.setBackgroundColor(getResources().getColor(R.color.healthy));
                }

            }
        });

    }


}