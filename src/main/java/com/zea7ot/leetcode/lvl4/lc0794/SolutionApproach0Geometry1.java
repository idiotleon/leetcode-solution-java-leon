/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/valid-tic-tac-toe-state/discuss/117580/Straightforward-Java-solution-with-explaination/243210
 *  https://leetcode.com/problems/valid-tic-tac-toe-state/discuss/117580/Straightforward-Java-solution-with-explaination
 */
package com.zea7ot.leetcode.lvl4.lc0794;

public class SolutionApproach0Geometry1 {
    public boolean validTicTacToe(String[] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].isEmpty())
            return false;

        final int NR = board.length, NC = board[0].length();

        int turns = 0;

        boolean xWin = isGameOver(board, 'X');
        boolean oWin = isGameOver(board, 'O');

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (board[row].charAt(col) == 'X')
                    ++turns;
                else if (board[row].charAt(col) == 'O')
                    --turns;
            }
        }

        if (turns < 0 || turns > 1 || turns == 0 && xWin || turns == 1 && oWin)
            return false;

        return true;
    }

    private boolean isGameOver(String[] board, char player) {
        // to check horizontal
        for (int row = 0; row < 3; ++row) {
            if (board[row].charAt(0) == player && board[row].charAt(0) == board[row].charAt(1)
                    && board[row].charAt(1) == board[row].charAt(2))
                return true;
        }

        // to check vertical
        for (int col = 0; col < 3; ++col) {
            if (board[0].charAt(col) == player && board[0].charAt(col) == board[1].charAt(col)
                    && board[1].charAt(col) == board[2].charAt(col))
                return true;
        }

        // to check diagonal
        if (board[1].charAt(1) == player
                && (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)
                        || board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)))
            return true;

        return false;
    }
}