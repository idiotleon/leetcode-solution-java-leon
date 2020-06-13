/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0348;

public class SolutionDesignTicTacToe {
    private int[] rows, cols;
    private int diagonal, antiDiagonal;

    /** Initialize your data structure here. */
    public SolutionDesignTicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        final int N = rows.length;
        final int TO_ADD = player == 1 ? 1 : -1;
        final int TARGET = player == 1 ? N : -N;
        
        rows[row] += TO_ADD;
        if(TARGET == rows[row]) return player;
        
        cols[col] += TO_ADD;
        if(TARGET == cols[col]) return player;
        
        if(row - col == 0) {
            diagonal += TO_ADD;
            if(TARGET == diagonal) return player;
        }
        
        if(row + col == N - 1) {
            antiDiagonal += TO_ADD;
            if(TARGET == antiDiagonal) return player;
        }
        
        return 0;
    }
}