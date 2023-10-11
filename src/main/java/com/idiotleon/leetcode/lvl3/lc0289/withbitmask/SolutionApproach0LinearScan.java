package com.idiotleon.leetcode.lvl3.lc0289.withbitmask;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/game-of-life/">LC289 Game of Life<w/a>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(1)
 * to acquire the current state:    board[row][col] & 1
 * to acquire the next state:       board[row][col] >> 1
 * Reference:
 * <a href="https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation">LC</a>
 */
@SuppressWarnings(UNUSED)
public class SolutionApproach0LinearScan {
    private static final int INITIAL_DEAD = 0;
    private static final int INITIAL_LIVE = 1;
    private static final int GOING_TO_REPRODUCE = 2;
    private static final int GOING_TO_LIVE = 3;

    public void gameOfLife(int[][] board) {
        // sanity check
        if (board == null || board.length == 0) return;

        final int NR = board.length, NC = board[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                int lives = liveNeighbors(row, col, board);

                // in the beginning, since every 2nd bit is 0,
                // only the time when the 2nd bit is turned into 1 is of interests.
                if (board[row][col] == INITIAL_LIVE && lives >= 2 && lives <= 3) {
                    board[row][col] = GOING_TO_LIVE; // to make the 2nd bit 1: 01 -> 11
                }

                if (board[row][col] == INITIAL_DEAD && lives == 3) {
                    board[row][col] = GOING_TO_REPRODUCE; // to make the 2nd bit 1: 00 -> 10
                }
            }
        }

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                board[row][col] >>= 1; // to acquire the next/2nd state
            }
        }
    }

    private int liveNeighbors(int row, int col, int[][] board) {
        final int NR = board.length, NC = board[0].length;

        int lives = 0;
        // to check all surroundings
        for (int nextRow = Math.max(row - 1, 0); nextRow <= Math.min(row + 1, NR - 1); ++nextRow) {
            for (int nextCol = Math.max(col - 1, 0); nextCol <= Math.min(col + 1, NC - 1); ++nextCol) {
                lives += board[nextRow][nextCol] & 1;
            }
        }
        lives -= board[row][col] & 1;
        return lives;
    }
}