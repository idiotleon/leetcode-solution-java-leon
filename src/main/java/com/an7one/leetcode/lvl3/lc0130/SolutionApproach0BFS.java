package com.an7one.leetcode.lvl3.lc0130;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/surrounded-regions/">LC0130</a>
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    private static final char LETTER_O = 'O';
    private static final char LETTER_X = 'X';
    private static final char PLACE_HOLDER = '.';

    public void solve(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        final int NR = board.length, NC = board[0].length;
        final Deque<int[]> queue = new ArrayDeque<>();

        // to get all 'O's on the border firstly
        for (int row = 0; row < NR; ++row) {
            if (board[row][0] == LETTER_O) {
                board[row][0] = PLACE_HOLDER;
                queue.addLast(new int[]{row, 0});
            }

            if (board[row][NC - 1] == LETTER_O) {
                board[row][NC - 1] = PLACE_HOLDER;
                queue.addLast(new int[]{row, NC - 1});
            }
        }

        for (int col = 1; col < NC - 1; ++col) {
            if (board[0][col] == LETTER_O) {
                board[0][col] = PLACE_HOLDER;
                queue.addLast(new int[]{0, col});
            }

            if (board[NR - 1][col] == LETTER_O) {
                board[NR - 1][col] = PLACE_HOLDER;
                queue.addLast(new int[]{NR - 1, col});
            }
        }

        // BFS for the 'O's, and mark it as '.'
        while (!queue.isEmpty()) {
            final int[] cur = queue.removeFirst();

            for (int d = 0; d < 4; ++d) {
                final int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];

                if (r < 0 || r >= NR || c < 0 || c >= NC || board[r][c] != LETTER_O)
                    continue;

                board[r][c] = PLACE_HOLDER;
                queue.addLast(new int[]{r, c});
            }
        }

        // to turn all '.' to 'O', and 'O' to 'X'
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (board[row][col] == LETTER_O)
                    board[row][col] = LETTER_X;
                if (board[row][col] == PLACE_HOLDER)
                    board[row][col] = LETTER_O;
            }
        }
    }
}