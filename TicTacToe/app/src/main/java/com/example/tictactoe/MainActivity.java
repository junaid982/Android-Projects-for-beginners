package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String p1 , p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        p1 = intent.getStringExtra("player1");
        p2 = intent.getStringExtra("player2");

        Toast.makeText(this, "Player1 "+p1, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Player2 "+p2 , Toast.LENGTH_SHORT).show();
    }
}