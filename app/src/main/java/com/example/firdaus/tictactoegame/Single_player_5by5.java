package com.example.firdaus.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Single_player_5by5 extends AppCompatActivity implements View.OnClickListener{

    boolean Player_X = true;
    int Turn_Count = 0;
    public Button b0, b1, b2, b3, b4, b5, b6, b7, b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24;
    Button Reset;
    TextView pl1,pl2;
    int result=0;
    int result2=0;
    int[][] boardStatus = new int[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_5by5);
        b0 = (Button) findViewById(R.id.bu1);
        b1 = (Button) findViewById(R.id.bu2);
        b2 = (Button) findViewById(R.id.bu3);
        b3 = (Button) findViewById(R.id.bu4);
        b4 = (Button) findViewById(R.id.bu5);
        b5 = (Button) findViewById(R.id.bu6);
        b6 = (Button) findViewById(R.id.bu7);
        b7 = (Button) findViewById(R.id.bu8);
        b8 = (Button) findViewById(R.id.bu9);
        b9 = (Button) findViewById(R.id.bu10);
        b10 = (Button) findViewById(R.id.bu11);
        b11 = (Button) findViewById(R.id.bu12);
        b12 = (Button) findViewById(R.id.bu13);
        b13 = (Button) findViewById(R.id.bu14);
        b14 = (Button) findViewById(R.id.bu15);
        b15 = (Button) findViewById(R.id.bu16);
        b16 = (Button) findViewById(R.id.bu17);
        b17 = (Button) findViewById(R.id.bu18);
        b18 = (Button) findViewById(R.id.bu19);
        b19 = (Button) findViewById(R.id.bu20);
        b20 = (Button) findViewById(R.id.bu21);
        b21 = (Button) findViewById(R.id.bu22);
        b22 = (Button) findViewById(R.id.bu23);
        b23 = (Button) findViewById(R.id.bu24);
        b24 = (Button) findViewById(R.id.bu25);
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
        b9.setOnClickListener((View.OnClickListener) this);
        b10.setOnClickListener((View.OnClickListener) this);
        b11.setOnClickListener((View.OnClickListener) this);
        b12.setOnClickListener((View.OnClickListener) this);
        b13.setOnClickListener((View.OnClickListener) this);
        b14.setOnClickListener((View.OnClickListener) this);
        b15.setOnClickListener((View.OnClickListener) this);
        b16.setOnClickListener((View.OnClickListener) this);
        b17.setOnClickListener((View.OnClickListener) this);
        b18.setOnClickListener((View.OnClickListener) this);
        b19.setOnClickListener((View.OnClickListener) this);
        b20.setOnClickListener((View.OnClickListener) this);
        b21.setOnClickListener((View.OnClickListener) this);
        b22.setOnClickListener((View.OnClickListener) this);
        b23.setOnClickListener((View.OnClickListener) this);
        b24.setOnClickListener((View.OnClickListener) this);
        initializeBoardStatus();
    }


    public void onClick(View view) {
        boolean resetButtonPressed = false;
        switch (view.getId()) {
            case R.id.bu1:
                if (Player_X) {
                    b0.setText("X");
                    boardStatus[0][0] = 1;
                } else {
                    b0.setText("0");
                    boardStatus[0][0] = 0;
                }
                b0.setEnabled(false);
                break;

            case R.id.bu2:
                if (Player_X) {
                    b1.setText("X");
                    boardStatus[0][1] = 1;
                } else {
                    b1.setText("0");
                    boardStatus[0][1] = 0;
                }
                b1.setEnabled(false);
                break;

            case R.id.bu3:
                if (Player_X) {
                    b2.setText("X");
                    boardStatus[0][2] = 1;
                } else {
                    b2.setText("0");
                    boardStatus[0][2] = 0;
                }
                b2.setEnabled(false);
                break;

            case R.id.bu4:
                if (Player_X) {
                    b3.setText("X");
                    boardStatus[0][3] = 1;
                } else {
                    b3.setText("0");
                    boardStatus[0][3] = 0;
                }
                b3.setEnabled(false);
                break;

            case R.id.bu5:
                if (Player_X) {
                    b4.setText("X");
                    boardStatus[0][4] = 1;
                } else {
                    b4.setText("0");
                    boardStatus[0][4] = 0;
                }
                b4.setEnabled(false);
                break;

            case R.id.bu6:
                if (Player_X) {
                    b5.setText("X");
                    boardStatus[1][0] = 1;
                } else {
                    b5.setText("0");
                    boardStatus[1][0] = 0;
                }
                b5.setEnabled(false);
                break;

            case R.id.bu7:
                if (Player_X) {
                    b6.setText("X");
                    boardStatus[1][1] = 1;
                } else {
                    b6.setText("0");
                    boardStatus[1][1] = 0;
                }
                b6.setEnabled(false);
                break;

            case R.id.bu8:
                if (Player_X) {
                    b7.setText("X");
                    boardStatus[1][2] = 1;
                } else {
                    b7.setText("0");
                    boardStatus[1][2] = 0;
                }
                b7.setEnabled(false);
                break;

            case R.id.bu9:
                if (Player_X) {
                    b8.setText("X");
                    boardStatus[1][3] = 1;
                } else {
                    b8.setText("0");
                    boardStatus[1][3] = 0;
                }
                b8.setEnabled(false);
                break;

            case R.id.bu10:
                if (Player_X) {
                    b9.setText("X");
                    boardStatus[1][4] = 1;
                } else {
                    b9.setText("0");
                    boardStatus[1][4] = 0;
                }
                b9.setEnabled(false);
                break;

            case R.id.bu11:
                if (Player_X) {
                    b10.setText("X");
                    boardStatus[2][0] = 1;
                } else {
                    b10.setText("0");
                    boardStatus[2][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.bu12:
                if (Player_X) {
                    b11.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    b11.setText("0");
                    boardStatus[2][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.bu13:
                if (Player_X) {
                    b12.setText("X");
                    boardStatus[2][2] = 1;
                } else {
                    b12.setText("0");
                    boardStatus[2][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.bu14:
                if (Player_X) {
                    b13.setText("X");
                    boardStatus[2][3] = 1;
                } else {
                    b13.setText("0");
                    boardStatus[2][3] = 0;
                }
                b13.setEnabled(false);
                break;

            case R.id.bu15:
                if (Player_X) {
                    b14.setText("X");
                    boardStatus[2][4] = 1;
                } else {
                    b14.setText("0");
                    boardStatus[2][4] = 0;
                }
                b14.setEnabled(false);
                break;

            case R.id.bu16:
                if (Player_X) {
                    b15.setText("X");
                    boardStatus[3][0] = 1;
                } else {
                    b15.setText("0");
                    boardStatus[3][0] = 0;
                }
                b15.setEnabled(false);
                break;

            case R.id.bu17:
                if (Player_X) {
                    b16.setText("X");
                    boardStatus[3][1] = 1;
                } else {
                    b16.setText("0");
                    boardStatus[3][1] = 0;
                }
                b16.setEnabled(false);
                break;

            case R.id.bu18:
                if (Player_X) {
                    b17.setText("X");
                    boardStatus[3][2] = 1;
                } else {
                    b17.setText("0");
                    boardStatus[3][2] = 0;
                }
                b17.setEnabled(false);
                break;

            case R.id.bu19:
                if (Player_X) {
                    b18.setText("X");
                    boardStatus[3][3] = 1;
                } else {
                    b18.setText("0");
                    boardStatus[3][3] = 0;
                }
                b18.setEnabled(false);
                break;

            case R.id.bu20:
                if (Player_X) {
                    b19.setText("X");
                    boardStatus[3][4] = 1;
                } else {
                    b19.setText("0");
                    boardStatus[3][4] = 0;
                }
                b19.setEnabled(false);
                break;

            case R.id.bu21:
                if (Player_X) {
                    b20.setText("X");
                    boardStatus[4][0] = 1;
                } else {
                    b20.setText("0");
                    boardStatus[4][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.bu22:
                if (Player_X) {
                    b21.setText("X");
                    boardStatus[4][1] = 1;
                } else {
                    b21.setText("0");
                    boardStatus[4][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.bu23:
                if (Player_X) {
                    b22.setText("X");
                    boardStatus[4][2] = 1;
                } else {
                    b22.setText("0");
                    boardStatus[4][2] = 0;
                }
                b22.setEnabled(false);
                break;

            case R.id.bu24:
                if (Player_X) {
                    b23.setText("X");
                    boardStatus[4][3] = 1;
                } else {
                    b23.setText("0");
                    boardStatus[4][3] = 0;
                }
                b23.setEnabled(false);
                break;

            case R.id.bu25:
                if (Player_X) {
                    b24.setText("X");
                    boardStatus[4][4] = 1;
                } else {
                    b24.setText("0");
                    boardStatus[4][4] = 0;
                }
                b24.setEnabled(false);
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
               System.out.println("Your Turn");
            } else {
                System.out.println("Player 2 turn");            }

            if (Turn_Count == 25) {
                Toast.makeText(view.getContext(),"Game Draw",Toast.LENGTH_SHORT).show();
            }
            checkWinner();
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 5; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] &&  boardStatus[i][0] == boardStatus[i][3]  &&  boardStatus[i][0] == boardStatus[i][4] ){
                if (boardStatus[i][0] == 1) {
                    Toast.makeText(Single_player_5by5.this,"You Win", Toast.LENGTH_LONG).show();
                    result=result+1;
                } else if (boardStatus[i][0] == 0) {
                    Toast.makeText(Single_player_5by5.this,"You Loose", Toast.LENGTH_LONG).show();
                    result2=result2+1;
                    break;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] && boardStatus[0][i] == boardStatus[3][i] && boardStatus[0][i] == boardStatus[4][i]) {
                if (boardStatus[0][i] == 1) {
                    Toast.makeText(Single_player_5by5.this,"You Win", Toast.LENGTH_LONG).show();
                    result=result+1;
                } else if (boardStatus[0][i] == 0) {
                    Toast.makeText(Single_player_5by5.this,"You Loose", Toast.LENGTH_LONG).show();
                    result2=result2+1;
                    break;
                }
            }
        }


        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] && boardStatus[0][0] == boardStatus[3][3] && boardStatus[0][0] == boardStatus[4][4]) {
            if (boardStatus[0][0] == 1) {
                Toast.makeText(Single_player_5by5.this,"You Win", Toast.LENGTH_LONG).show();
                result=result+1;
            } else if (boardStatus[0][0] == 0) {
                Toast.makeText(Single_player_5by5.this,"You Loose", Toast.LENGTH_LONG).show();
                result2=result2+1;
            }
        }

        if (boardStatus[0][4] == boardStatus[1][3] && boardStatus[0][4] == boardStatus[2][2] && boardStatus[0][4] == boardStatus[3][1] && boardStatus[0][4] == boardStatus[4][0]) {
            if (boardStatus[0][2] == 1) {
                Toast.makeText(Single_player_5by5.this,"You Win", Toast.LENGTH_LONG).show();
                result=result+1;
            } else if (boardStatus[0][2] == 0) {;
                Toast.makeText(Single_player_5by5.this,"You Loose", Toast.LENGTH_LONG).show();
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
        b9.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b13.setText("");
        b14.setText("");
        b15.setText("");
        b16.setText("");
        b17.setText("");
        b18.setText("");
        b19.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b24.setText("");
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b13.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);
        b17.setEnabled(true);
        b18.setEnabled(true);
        b19.setEnabled(true);
        b20.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);
        b23.setEnabled(true);
        b24.setEnabled(true);



        Player_X=true;
        Turn_Count=0;
        initializeBoardStatus();
        Toast.makeText(Single_player_5by5.this,"Start Again.", Toast.LENGTH_LONG).show();
    }

    private void initializeBoardStatus(){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                boardStatus[i][j]=-1;
            }
        }
    }
}
