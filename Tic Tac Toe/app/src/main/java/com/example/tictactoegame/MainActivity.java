package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,resetBtn;
    TextView result;
    int flag = 0;
    int stepCount = 0;

    //to get button value
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    String p = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        init();
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


    }



    public void Check(View view) {
        Button btnCurrent = (Button) view;

        if (btnCurrent.getText().equals("")) {
            stepCount++;


            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
                btnCurrent.setText("0");
                flag = 0;
            }

            ///check step count
            if (stepCount > 4) {
                //get btn values

                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //check condition for winner

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    p = getPlayer(b1);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);


                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    p = getPlayer(b4);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);


                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    p = getPlayer(b7);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    p = getPlayer(b1);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    p = getPlayer(b2);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    p = getPlayer(b3);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    p = getPlayer(b1);
                    result.setText("Winner is "+p);
                    resetBtn.setVisibility(View.VISIBLE);

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    p = getPlayer(b3);
                    result.setText("Winner is "+getPlayer(b3));
                    resetBtn.setVisibility(View.VISIBLE);
                }
                else {
                    result.setText("Match Draw");
                    resetBtn.setVisibility(View.VISIBLE);
                }



            }
        }


    }



    public String getPlayer(String b) {
        return b.equals("X")?"Player 1":"Player 2";
        /*
        if (b.equals("X") ) {
            player = "Player 1";
        } else if(b.equals("0")){
            player = "Player 2";
        }
        return player;*/
    }
}











