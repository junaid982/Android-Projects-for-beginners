package com.example.tictactoe2;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, result, restartBtn;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int stepCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        result = findViewById(R.id.result);
        restartBtn = findViewById(R.id.restartBtn);
    }

    public void onCheck(View view) {
        TextView currentBtn = (TextView) view;

        if (currentBtn.getText().equals("")) {
            stepCount++;

            if (flag == 0) {
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("O");
                flag = 0;
            }

            if (stepCount > 4 ) {


                b1 = btn1.getText().toString();

                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();


                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    setBgColor(btn1, btn2, btn3);
                    result.setText("Winner is " + getPlayer(b1));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    setBgColor(btn4, btn5, btn6);
                    result.setText("Winner is " + getPlayer(b4));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    setBgColor(btn7, btn8, btn9);
                    result.setText("Winner is " + getPlayer(b7));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    setBgColor(btn1, btn4, btn7);
                    result.setText("Winner is " + getPlayer(b1));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    setBgColor(btn2, btn5, btn8);
                    result.setText("Winner is " + getPlayer(b2));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    setBgColor(btn3, btn6, btn9);
                    result.setText("Winner is " + getPlayer(b3));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    setBgColor(btn1, btn5, btn9);
                    result.setText("Winner is " + getPlayer(b1));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    setBgColor(btn3, btn5, btn7);
                    result.setText("Winner is " + getPlayer(b3));
                    restartBtn.setVisibility(View.VISIBLE);

                } else if (stepCount==9) {
                    result.setText("Match Draw");
                    restartBtn.setVisibility(View.VISIBLE);
                }


            }
        }

    }


    public String getPlayer(String b) {
        return b.equals("X") ? "Player 1" : "Player 2";
    }

    public void setBgColor(TextView b1, TextView b2, TextView b3) {
        b1.setBackgroundColor(Color.RED);
        b2.setBackgroundColor(Color.RED);
        b3.setBackgroundColor(Color.RED);

    }


}




