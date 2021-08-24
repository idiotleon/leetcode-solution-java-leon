package com.an7one.leetcode.lvl3.lc0036;

import com.an7one.util.Constant;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * <p>
 * Time Complexity:     O(9 * 9) ~ O(1)
 * Space Complexity:    O(9 * 9) ~ O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Set1 {
    public boolean isValidSudoku(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        final int N = 9;
        final char EMPTY = '.';

        Set<String> seen = new HashSet<>();
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                char number = board[row][col];
                if (number != EMPTY) {
                    if (!seen.add(number + " in row " + row) || !seen.add(number + " in column " + col)
                            || !seen.add(number + " in block " + row / 3 + "-" + col / 3))
                        return false;
                }
            }
        }

        return true;
    }
}