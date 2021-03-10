/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.an7one.leetcode.lvl3.lc0130;

public class SolutionApproach0DFS {
    private int[] DIRS = { 0, -1, 0, 1, 0 };

    private static final char LETTER_O = 'O';
    private static final char LETTER_X = 'X';
    private static final char PLACE_HOLDER = '.';

    public void solve(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        // boundaries
        final int NR = board.length, NC = board[0].length;

        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                if (board[row][col] == LETTER_O) {
                    if (isBorderAttached(board, row, col)) {
                        mark(board, row, col, LETTER_O);
                    } else
                        mark(board, row, col, LETTER_X);
                }
            }
        }
    }

    private void mark(char[][] board, int row, int col, char marker) {
        final int NR = board.length, NC = board[0].length;
        if (row < 0 || col < 0 || row >= NR || col >= NC || board[row][col] != PLACE_HOLDER)
            return;

        board[row][col] = marker;

        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            mark(board, r, c, marker);
        }
    }

    private boolean isBorderAttached(char[][] board, int row, int col) {
        final int NR = board.length, NC = board[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || board[row][col] != LETTER_O)
            return false;

        if (board[row][col] == LETTER_O && (row == 0 || col == 0 || row == NR - 1 || col == NC - 1))
            return true;

        board[row][col] = PLACE_HOLDER;

        boolean res = false;

        for (int d = 0; d < 4; ++d) {
            res = res || isBorderAttached(board, row + DIRS[d], col + DIRS[d + 1]);
        }

        return res;

        /*
         * equivalently return isBorderAttached(board, row - 1, col) ||
         * isBorderAttached(board, row + 1, col) || isBorderAttached(board, row, col -
         * 1) || isBorderAttached(board, row, col + 1);
         */
    }
}