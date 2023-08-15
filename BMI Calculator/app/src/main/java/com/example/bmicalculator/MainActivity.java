package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText age = findViewById(R.id.age);
                EditText height = findViewById(R.id.height);

                Toast.makeText(MainActivity.this, "age is "+age.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "height is "+height.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}