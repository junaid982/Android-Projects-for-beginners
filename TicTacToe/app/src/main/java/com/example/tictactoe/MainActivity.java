package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String p1, p2;
    TextView btn1 , btn2 , btn3 ,btn4 ,btn5 ,btn6 ,btn7 ,btn8 ,btn9 ,restartBtn ,result;

    String b1,b2 , b3 , b4 , b5 , b6 , b7 ,b8 ,b9 , r;
    int btnCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        p1 = intent.getStringExtra("player1");
        p2 = intent.getStringExtra("player2");


//        Toast.makeText(this, "Player1 "+p1, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Player2 "+p2 , Toast.LENGTH_SHORT).show();

        init();
    }


    public void check(View view){
        TextView currentBtn = (TextView) view;
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();


        if(btnCount == 0){
            currentBtn.setText("X");
            btnCount = 1;

        }else{
            currentBtn.setText("O");
            btnCount = 0;
        }

        if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
            
        }


    }

    public void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn4 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        result = findViewById(R.id.result);
        restartBtn = findViewById(R.id.restartBtn);
    }


}