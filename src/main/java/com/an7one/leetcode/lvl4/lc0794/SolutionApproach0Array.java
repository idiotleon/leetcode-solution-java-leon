/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 * 
 * Time Complexity:     O(3 * 3) ~ O(1)
 * Space Complexity:    O(3 * 3) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/valid-tic-tac-toe-state/discuss/318887/Java-faster-than-100-Memory-9966
 */
package com.an7one.leetcode.lvl4.lc0794;

public class SolutionApproach0Array {
    private char[][] gameBoard;

    public boolean validTicTacToe(String[] board) {
        gameBoard = new char[3][3];
        unpackBoard(board);

        return gameBoardValidation();
    }

    private boolean gameBoardValidation() {
        int numX = count('X');
        int numO = count('O');

        if (numX > numO + 1 || numX < numO)
            return false;

        if (winner('X') && winner('O'))
            return false;
        else if (winner('X'))
            return numX == numO + 1;
        else if (winner('O'))
            return numX == numO;
        else
            return true;
    }

    private void unpackBoard(String[] board) {
        for (int row = 0; row < 3; ++row) {
            char[] chs = board[row].toCharArray();
            for (int col = 0; col < 3; ++col) {
                gameBoard[row][col] = chs[col];
            }
        }
    }

    private boolean winner(char player) {
        if (validateRows(player))
            return true;
        if (validateColumns(player))
            return true;
        if (validateDiagonal(player))
            return true;

        return false;
    }

    private int count(char player) {
        int num = 0;
        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 3; ++col)
                if (gameBoard[row][col] == player)
                    ++num;
        return num;
    }

    private boolean validateRows(char player) {
        for (int row = 0; row < 3; ++row)
            if (gameBoard[row][0] == player && gameBoard[row][1] == player && gameBoard[row][2] == player)
                return true;

        return false;
    }

    private boolean validateColumns(char player) {
        for (int col = 0; col < 3; ++col)
            if (gameBoard[0][col] == player && gameBoard[1][col] == player && gameBoard[2][col] == player)
                return true;

        return false;
    }

    private boolean validateDiagonal(char player) {
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player)
            return true;

        if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player)
            return true;

        return false;
    }
}