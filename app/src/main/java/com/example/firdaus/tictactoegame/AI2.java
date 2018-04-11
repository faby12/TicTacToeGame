package com.example.firdaus.tictactoegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firdaus on 10/04/2018.
 */

public class AI2 {
    protected String myMark;
    protected String oppMark;
    protected String[][] board1;
    AI2(String marker) {
        this.myMark = marker;
        this.oppMark = (myMark == "X") ? "O" : "X";
    }
    public int[] move(GameBoard2 board1, String marker) {
        this.myMark = marker;
        this.oppMark = (myMark == "X") ? "O" : "X";
        this.board1 = board1.getBoard();
        int[] result = minmax(2, myMark, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[] { result[1], result[2] };
    }
    private int[] minmax(int depth, String player, int alpha, int beta) {
        List<int[]> nextMoves = generateMoves();
// mySeed is maximizing; while oppSeed is minimizing
        int score;
        int bestRow = -1;
        int bestCol = -1;
        if (nextMoves.isEmpty() || depth == 0) {
// Game over or depth reached, evaluate score
            score = evaluate();
            return new int[] { score, bestRow, bestCol };
        } else {
            for (int[] move : nextMoves) {
// try this move for the current "player"
                board1[move[0]][move[1]] = player;
                if (player == myMark) { // mySeed (computer) is maximizing
// player
                    score = minmax(depth - 1, oppMark, alpha, beta)[0];
                    if (score > alpha) {
                        alpha = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else { // oppSeed is minimizing player
                    score = minmax(depth - 1, myMark, alpha, beta)[0];
                    if (score < beta) {
                        beta = score;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
// undo move
                board1[move[0]][move[1]] = "";
// cut-off
                if (alpha >= beta)
                    break;
            }
        }
        return new int[] { (player == myMark) ? alpha : beta, bestRow, bestCol };
    }
    private List<int[]> generateMoves() {
        List<int[]> nextMoves = new ArrayList<int[]>();
// If gameover, i.e., no next move
        if (hasWon(myMark) || hasWon(oppMark)) {
            return nextMoves; // return empty list
        }
// Search for empty cells and add to the List
        for (int row = 0; row < 5; ++row) {
            for (int col = 0; col < 5; ++col) {
                if (board1[row][col] == "") {
                    nextMoves.add(new int[] { row, col });
                }
            }
        }
        return nextMoves;
    }
    /**
     * The heuristic evaluation function for the current board
     *
     * @Return +100, +10, +1 for EACH 3-, 2-, 1-in-a-line for computer. -100,
     * -10, -1 for EACH 3-, 2-, 1-in-a-line for opponent. 0 otherwise
     */
    private int evaluate() {
        int score = 0;
// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2
// diagonals)
        score += evaluateLine(0, 0, 0, 1, 0, 2,0,3,0,4); // row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2,1,3,1,4); // row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2,2,3,2,4); // row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0,3,0,4,0); // col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1,3,1,4,1); // col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2,3,2,4,2); // col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2,3,3,4,4); // diagonal
        score += evaluateLine(0, 4, 1, 3, 2, 2,3,1,4,0); // alternate diagonal
        return score;
    }
    /**
     * The heuristic evaluation function for the given line of 3 cells
     *
     * @Return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer. -100, -10, -1
     * for 3-, 2-, 1-in-a-line for opponent. 0 otherwise
     */
    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3, int row4, int col4, int row5, int col5) {
        int score = 0;
// First cell
        if (board1[row1][col1] == myMark) {
            score = 1;
        } else if (board1[row1][col1] == oppMark) {
            score = -1;
        }
// Second cell
        if (board1[row2][col2] == myMark) {
            if (score == 1) { // cell1 is mySeed
                score = 10;
            } else if (score == -1) { // cell1 is oppSeed
                return 0;
            } else { // cell1 is empty
                score = 1;
            }
        } else if (board1[row2][col2] == oppMark) {
            if (score == -1) { // cell1 is oppSeed
                score = -10;
            } else if (score == 1) { // cell1 is mySeed
                return 0;
            } else { // cell1 is empty
                score = -1;
            }
        }
// Third cell
        if (board1[row3][col3] == myMark) {
            if (score > 0) { // cell1 and/or cell2 is mySeed
                score *= 10;
            } else if (score < 0) { // cell1 and/or cell2 is oppSeed
                return 0;
            } else { // cell1 and cell2 are empty
                score = 1;
            }
        } else if (board1[row3][col3] == oppMark) {
            if (score < 0) { // cell1 and/or cell2 is oppSeed
                score *= 10;
            } else if (score > 1) { // cell1 and/or cell2 is mySeed
                return 0;
            } else { // cell1 and cell2 are empty
                score = -1;
            }
        }
        return score;
    }
    public boolean hasWon(String thePlayer) {
// Check Diagonals
        if (board1[0][0] == thePlayer && board1[1][1] == thePlayer
                && board1[2][2] == thePlayer && board1[3][3] == thePlayer && board1[4][4] == thePlayer)
            return true;
        if (board1[4][0] == thePlayer && board1[3][1] == thePlayer
                && board1[2][2] == thePlayer && board1[1][3] == thePlayer && board1[0][4] == thePlayer)
            return true;
        for (int i = 0; i < 5; i++) {
// Check Rows
            if (board1[i][0] == thePlayer && board1[i][1] == thePlayer
                    && board1[i][2] == thePlayer && board1[i][3] == thePlayer && board1[i][4] == thePlayer)
                return true;
// Check Columns
            if (board1[0][i] == thePlayer && board1[1][i] == thePlayer
                    && board1[2][i] == thePlayer  && board1[3][i] == thePlayer  && board1[4][i] == thePlayer)
                return true;
        }
        return false;
    }
}
