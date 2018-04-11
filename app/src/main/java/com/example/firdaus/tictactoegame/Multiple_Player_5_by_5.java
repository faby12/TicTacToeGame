package com.example.firdaus.tictactoegame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Multiple_Player_5_by_5 extends AppCompatActivity {
    private GameBoard2 board1 = null;
    private int moveCount = 0, xloc = 0, yloc = 0;
    private String mark = "X", aiMark = "O";
    private boolean isOver = false;
    private AI2 ai = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple__player_5_by_5);
        board1 = new GameBoard2();
        ai = new AI2(aiMark);
    }

    public void resetClick(View v) {
        clear();
        if (aiMark =="X") getAIMove(board1);
    }

    public void cellClick(View v) {
//Get the id of the clicked object and assign it to a Textview variable
        TextView cell = (TextView) findViewById(v.getId());
//Check the content and make sure the cell is empty and that the game isn't over
        String content = (String) cell.getText();
        if (content == "" && !isOver) {


//Find the X Y location values of the particular cell that was clicked
            switch (cell.getId()) {


                case R.id.cell1:
                    xloc = 0;
                    yloc = 0;
                    break;
                case R.id.cell2:
                    xloc = 0;
                    yloc = 1;
                    break;
                case R.id.cell3:
                    xloc = 0;
                    yloc = 2;
                    break;
                case R.id.cell4:
                    xloc = 0;
                    yloc = 3;
                    break;
                case R.id.cell5:
                    xloc = 0;
                    yloc = 4;
                    break;
                case R.id.cell6:
                    xloc = 1;
                    yloc = 0;
                    break;
                case R.id.cell7:
                    xloc = 1;
                    yloc = 1;
                    break;
                case R.id.cell8:
                    xloc = 1;
                    yloc = 2;
                    break;
                case R.id.cell9:
                    xloc = 1;
                    yloc = 3;
                    break;
                case R.id.cell10:
                    xloc = 1;
                    yloc = 4;
                    break;
                case R.id.cell11:
                    xloc = 2;
                    yloc = 0;
                    break;
                case R.id.cell12:
                    xloc = 2;
                    yloc = 1;
                    break;
                case R.id.cell13:
                    xloc = 2;
                    yloc = 2;
                    break;
                case R.id.cell14:
                    xloc = 2;
                    yloc = 3;
                    break;
                case R.id.cell15:
                    xloc = 2;
                    yloc = 4;
                    break;
                case R.id.cell16:
                    xloc = 3;
                    yloc = 0;
                    break;
                case R.id.cell17:
                    xloc = 3;
                    yloc = 1;
                    break;
                case R.id.cell18:
                    xloc = 3;
                    yloc = 2;
                    break;
                case R.id.cell19:
                    xloc = 3;
                    yloc = 3;
                    break;
                case R.id.cell20:
                    xloc = 3;
                    yloc = 4;
                    break;
                case R.id.cell21:
                    xloc = 4;
                    yloc = 0;
                    break;
                case R.id.cell22:
                    xloc = 4;
                    yloc = 1;
                    break;
                case R.id.cell23:
                    xloc = 4;
                    yloc = 2;
                    break;
                case R.id.cell24:
                    xloc = 4;
                    yloc = 3;
                    break;
                case R.id.cell25:
                    xloc = 4;
                    yloc = 4;
                    break;

            }

            board1.placeMark(xloc, yloc, mark);
            cell.setText(mark);
            //Increment move Count because a move was just made
            moveCount++;
//Check to see if the game is over
            isOver = checkEnd(mark);
//if the game game is over get the AI's move
            if (!isOver)
                getAIMove(board1);
        }
    }

    public void onRadioButtonClicked(View view) {
//Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


//Check which radio button was clicked
        switch(view.getId()) {
//If the user wants to be X just clear the board and wait for his move
            case R.id.radio_X:
                if (checked)
                    mark = "X"; aiMark = "O"; clear();
                break;


//If the user wants to be O's then clear the board and get the AI's opening move
            case R.id.radio_O:
                if (checked)
                    mark = "O"; aiMark = "X"; clear(); getAIMove(board1);
                break;
        }
    }

    private boolean checkEnd(String player) {
//Checks the virtual board for a winner if there's a winner announce it with the provided player
        if (board1.isWinner())
        {announce(true, player);
            return true;
        }
//Check to see if we've reached our move total meaning it's a draw
        else if (moveCount >= 25)
        {announce(false, player);
            return true;
        }
//If neither win or draw then the game is still on
        return false;
    }

    private void announce(boolean endState, String player) {
//Check for if it's a win or a draw. if it's a win amend player with wins!
// if it's a lose replace player with it's a draw! I did this just because why
// declare another String when I can just reuse the one I have?
        if (endState == true)
            player = player + " wins!";
        else
            player = "It's a draw!";
//Get the application Context and setup the Toast notification with the end state info
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, player, Toast.LENGTH_LONG);
        toast.show();
    }

    private void clear() {
//Get the id list of all the Textview cells
        int[] idList = { R.id.cell1, R.id.cell2, R.id.cell3, R.id.cell4, R.id.cell5, R.id.cell6, R.id.cell7, R.id.cell8, R.id.cell9,R.id.cell10,R.id.cell11,R.id.cell12,R.id.cell13,R.id.cell14,R.id.cell15,R.id.cell16,R.id.cell17,R.id.cell18,R.id.cell19,R.id.cell20,R.id.cell21,R.id.cell22,R.id.cell23,R.id.cell24,R.id.cell25 };
        TextView cell;
//For each cell clear the text with an empty string
        for (int item : idList) {
            cell = (TextView) findViewById(item);
            cell.setText("");
        }
//Reset the game state and clear the virtual board
        isOver = false;
        moveCount = 0;
        board1.clear();
    }

    private void getAIMove(GameBoard2 board1) {
//Send the board to the AI for it to determine and return the move in an array {x,y}
        int[] move = ai.move(board1,aiMark);
        TextView cell = null;
//Determine the right cell to use by id first go to the right row then the right column
        switch (move[0]) {
            case 0:
                switch (move[1]) {
                    case 0:
                        cell = (TextView) findViewById(R.id.cell1); break;
                    case 1:
                        cell = (TextView) findViewById(R.id.cell2); break;
                    case 2:
                        cell = (TextView) findViewById(R.id.cell3); break;
                    case 3:
                        cell = (TextView) findViewById(R.id.cell4); break;
                    case 4:
                        cell = (TextView) findViewById(R.id.cell5); break;
                }
                break;
            case 1:
                switch (move[1]) {
                    case 0:
                        cell = (TextView) findViewById(R.id.cell6); break;
                    case 1:
                        cell = (TextView) findViewById(R.id.cell7); break;
                    case 2:
                        cell = (TextView) findViewById(R.id.cell8); break;
                    case 3:
                        cell = (TextView) findViewById(R.id.cell9); break;
                    case 4:
                        cell = (TextView) findViewById(R.id.cell10); break;
                }
                break;
            case 2:
                switch (move[1]) {
                    case 0:
                        cell = (TextView) findViewById(R.id.cell11); break;
                    case 1:
                        cell = (TextView) findViewById(R.id.cell12); break;
                    case 2:
                        cell = (TextView) findViewById(R.id.cell13); break;
                    case 3:
                        cell = (TextView) findViewById(R.id.cell14); break;
                    case 4:
                        cell = (TextView) findViewById(R.id.cell15); break;
                }
                break;
            case 3:
                switch (move[1]) {
                    case 0:
                        cell = (TextView) findViewById(R.id.cell16); break;
                    case 1:
                        cell = (TextView) findViewById(R.id.cell17); break;
                    case 2:
                        cell = (TextView) findViewById(R.id.cell18); break;
                    case 3:
                        cell = (TextView) findViewById(R.id.cell19); break;
                    case 4:
                        cell = (TextView) findViewById(R.id.cell20); break;
                }
                break;
            case 4:
                switch (move[1]) {
                    case 0:
                        cell = (TextView) findViewById(R.id.cell21); break;
                    case 1:
                        cell = (TextView) findViewById(R.id.cell22); break;
                    case 2:
                        cell = (TextView) findViewById(R.id.cell23); break;
                    case 3:
                        cell = (TextView) findViewById(R.id.cell24); break;
                    case 4:
                        cell = (TextView) findViewById(R.id.cell25); break;
                }
                break;
        }


//Make sure there's nothing already in the cell
// then place the mark with the ai's Mark, increment move count
// and check to see if the game's over
        if (cell != null && cell.getText() == "") {
            board1.placeMark(move[0], move[1], aiMark);
            cell.setText(aiMark);
            moveCount++;
            isOver = checkEnd(aiMark);
        }
    }

}
