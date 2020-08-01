/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Time Complexity:     O(9 * 9) ~ O(1)
 * Space Complexity:    O(9 * 9) ~ O(1)
 */
package com.zea7ot.lc.lvl3.lc0036;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public boolean isValidSudoku(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        final int N = 9;
        final char EMPTY = '.';

        Set<String> seen = new HashSet<String>();
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                if (board[row][col] == EMPTY)
                    continue;
                final String ID = "(" + board[row][col] + ")";
                if (!seen.add(ID + row) || !seen.add(col + ID) || !seen.add(row / 3 + ID + col / 3))
                    return false;
            }
        }

        return true;
    }
}