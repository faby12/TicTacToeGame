package com.example.firdaus.tictactoegame;

import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Single_Player extends AppCompatActivity implements View.OnClickListener{
    boolean Player_X = true;
    int Turn_Count = 0;
    public Button b0, b1, b2, b3, b4, b5, b6, b7, b8;
    Button Reset;
    TextView pl1,pl2;
    int result=0;
    int result2=0;
    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single__player);
        b0 = (Button) findViewById(R.id.but1);
        b1 = (Button) findViewById(R.id.but2);
        b2 = (Button) findViewById(R.id.but3);
        b3 = (Button) findViewById(R.id.but4);
        b4 = (Button) findViewById(R.id.but5);
        b5 = (Button) findViewById(R.id.but6);
        b6 = (Button) findViewById(R.id.but7);
        b7 = (Button) findViewById(R.id.but8);
        b8 = (Button) findViewById(R.id.but9);
        Reset = (Button) findViewById(R.id.reset);
       pl1=(TextView) findViewById(R.id.p1);
        pl2=(TextView) findViewById(R.id.pl2);
        Reset.setOnClickListener((View.OnClickListener) this);
        b0.setOnClickListener((View.OnClickListener) this);
        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
        b5.setOnClickListener((View.OnClickListener) this);
        b6.setOnClickListener((View.OnClickListener) this);
        b7.setOnClickListener((View.OnClickListener) this);
        b8.setOnClickListener((View.OnClickListener) this);
        initializeBoardStatus();
    }


    @Override
    public void onClick(View view) {
        boolean resetButtonPressed = false;
        switch (view.getId()) {
            case R.id.but1:
                if (Player_X) {
                    b0.setText("X");
                    boardStatus[0][0] = 1;
                } else {
                    b0.setText("0");
                    boardStatus[0][0] = 0;
                }
                b0.setEnabled(false);
                break;

            case R.id.but2:
                if (Player_X) {
                    b1.setText("X");
                    boardStatus[0][1] = 1;
                } else {
                    b1.setText("0");
                    boardStatus[0][1] = 0;
                }
                b1.setEnabled(false);
                break;

            case R.id.but3:
                if (Player_X) {
                    b2.setText("X");
                    boardStatus[0][2] = 1;
                } else {
                    b2.setText("0");
                    boardStatus[0][2] = 0;
                }
                b2.setEnabled(false);
                break;

            case R.id.but4:
                if (Player_X) {
                    b3.setText("X");
                    boardStatus[1][0] = 1;
                } else {
                    b3.setText("0");
                    boardStatus[1][0] = 0;
                }
                b3.setEnabled(false);
                break;

            case R.id.but5:
                if (Player_X) {
                    b4.setText("X");
                    boardStatus[1][1] = 1;
                } else {
                    b4.setText("0");
                    boardStatus[1][1] = 0;
                }
                b4.setEnabled(false);
                break;

            case R.id.but6:
                if (Player_X) {
                    b5.setText("X");
                    boardStatus[1][2] = 1;
                } else {
                    b5.setText("0");
                    boardStatus[1][2] = 0;
                }
                b5.setEnabled(false);
                break;

            case R.id.but7:
                if (Player_X) {
                    b6.setText("X");
                    boardStatus[2][0] = 1;
                } else {
                    b6.setText("0");
                    boardStatus[2][0] = 0;
                }
                b6.setEnabled(false);
                break;

            case R.id.but8:
                if (Player_X) {
                    b7.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    b7.setText("0");
                    boardStatus[2][1] = 0;
                }
                b7.setEnabled(false);
                break;

            case R.id.but9:
                if (Player_X) {
                    b8.setText("X");
                    boardStatus[2][2] = 1;
                } else {
                    b8.setText("0");
                    boardStatus[2][2] = 0;
                }
                b8.setEnabled(false);
                break;

            case R.id.reset:
                resetButtonPressed = true;
                break;

            default:
                break;
        }

        if (resetButtonPressed) {
            resetBoard();
        } else {
            Turn_Count++;
            Player_X = !Player_X;

            if (Player_X) {
                Toast.makeText(view.getContext(),"Your Turn",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(view.getContext(),"Player 2's turn",Toast.LENGTH_SHORT).show();
            }

            if (Turn_Count == 9) {
                Toast.makeText(view.getContext(),"Game Draw",Toast.LENGTH_SHORT).show();
            }
            checkWinner();
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    Toast.makeText(Single_Player.this,"You Win", Toast.LENGTH_LONG).show();
                    result=result+1;
                } else if (boardStatus[i][0] == 0) {
                    Toast.makeText(Single_Player.this,"You Loose", Toast.LENGTH_LONG).show();
                    result2=result2+1;
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    Toast.makeText(Single_Player.this,"You Win", Toast.LENGTH_LONG).show();
                    result=result+1;
                } else if (boardStatus[0][i] == 0) {
                    Toast.makeText(Single_Player.this,"You Loose", Toast.LENGTH_LONG).show();
                    result2=result2+1;
                    break;
                }
            }
        }


        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                Toast.makeText(Single_Player.this,"You Win", Toast.LENGTH_LONG).show();
                result=result+1;
            } else if (boardStatus[0][0] == 0) {
                Toast.makeText(Single_Player.this,"You Loose", Toast.LENGTH_LONG).show();
                result2=result2+1;
            }
        }

        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                Toast.makeText(Single_Player.this,"You Win", Toast.LENGTH_LONG).show();
                result=result+1;
            } else if (boardStatus[0][2] == 0) {;
                Toast.makeText(Single_Player.this,"You Loose", Toast.LENGTH_LONG).show();
                result2=result2+1;
            }
            pl1.setText(String.valueOf(result));
            pl2.setText(String.valueOf(result2));
        }
    }

    private void resetBoard(){
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);


        Player_X=true;
        Turn_Count=0;
        initializeBoardStatus();
        Toast.makeText(Single_Player.this,"Start Again.", Toast.LENGTH_LONG).show();
    }

    private void initializeBoardStatus(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                boardStatus[i][j]=-1;
            }
        }
    }
}