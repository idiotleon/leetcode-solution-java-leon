/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * Time Complexity:     O(9 ^ NUM(BLANKS))
 *  
 * Space Compelxity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sudoku-solver/discuss/15911/Less-than-30-line-clean-java-solution-using-DFS
 */
package com.zea7ot.lc.lvl5.lc0037;

import java.util.Arrays;

public class SolutionApproach0Backtrack {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }
    
    private boolean backtrack(char[][] board, int d){
        if(d == 81) return true; // solution found
        int row = d / 9, col = d % 9;
        if(board[row][col] != '.') return backtrack(board, d + 1);
        
        boolean[] flag = new boolean[10];
        validate(row, col, board, flag);
        for(int k = 1; k <= 9; k++){
            if(flag[k]){
                board[row][col] = (char)('0' + k);
                if(backtrack(board, d + 1)) return true;
            }
        }
        board[row][col] = '.';
        return false;
    }

    private void validate(int row, int col, char[][] board, boolean[] flag){
        Arrays.fill(flag, true);
        for(int k = 0; k < 9; k++){
            if(board[row][k] != '.') flag[board[row][k] - '0'] = false;
            if(board[k][col] != '.') flag[board[k][col] - '0'] = false;
            
            int r = row / 3 * 3 + k / 3;
            int c = col / 3 * 3 + k % 3;
            if(board[r][c] != '.') flag[board[r][c] - '0'] = false;
        }
    }
}