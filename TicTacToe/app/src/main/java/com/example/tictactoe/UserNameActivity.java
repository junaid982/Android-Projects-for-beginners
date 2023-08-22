package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserNameActivity extends AppCompatActivity {

    EditText playerName1, playerName2;
    TextView startBtn;
    String p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        Intent intent = new Intent(UserNameActivity.this, MainActivity.class);
        init();


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(UserNameActivity.this, "Button Click", Toast.LENGTH_SHORT).show();
                p1 = playerName1.getText().toString();
                p2 = playerName2.getText().toString();

                if (p1.equals("")) {
//                    playerName1.setBackground(Drawable.createFromPath("#ff5858"));
                    Toast.makeText(UserNameActivity.this, "Player Name Empty", Toast.LENGTH_SHORT).show();
                } else if (p1.equals("")) {
//                    playerName2.setBackground(Drawable.createFromPath("#ff5858"));
                    Toast.makeText(UserNameActivity.this, "Player Name Empty", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("player1", p1);
                    intent.putExtra("player2", p2);

                    startActivity(intent);
                    finish();
                }


            }
        });


    }


    public void init() {
        startBtn = findViewById(R.id.startBtn);
        playerName1 = findViewById(R.id.playerName1);
        playerName2 = findViewById(R.id.playerName2);
    }


}