/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Time Complexity:     O(9 * 9) ~ O(1)
 * Space Complexity:    O(9 * 9) ~ O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0036;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set2 {
    public boolean isValidSudoku(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        final int N = 9;
        final char EMPTY = '.';

        for (int i = 0; i < N; i++) {
            Set<Character> rows = new HashSet<Character>();
            Set<Character> columns = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != EMPTY && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != EMPTY && !columns.add(board[j][i]))
                    return false;
                int rowIndex = 3 * (i / 3), colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
                        && !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }

        return true;
    }
}