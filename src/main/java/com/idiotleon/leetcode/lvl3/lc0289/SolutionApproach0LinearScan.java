/**
 * https://leetcode.com/problems/game-of-life/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation/193726
 *  https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation/193726
 */
package com.idiotleon.leetcode.lvl3.lc0289;

public class SolutionApproach0LinearScan {
    private static final int[][] DIRS = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
            { -1, 1 } };
    private static final int STATE_DEAD = 2;
    private static final int STATE_LIVE = 3;

    public void gameOfLife(int[][] board) {
        final int NR = board.length, NC = board[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                int liveNeighbors = liveNeighbors(row, col, board);
                if (board[row][col] == 0 && liveNeighbors == 3)
                    board[row][col] = STATE_LIVE;
                else if (board[row][col] == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3)
                        continue;
                    if (liveNeighbors < 2 || liveNeighbors > 3)
                        board[row][col] = STATE_DEAD;
                }
            }
        }

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (board[row][col] == STATE_DEAD)
                    board[row][col] = 0;
                if (board[row][col] == STATE_LIVE)
                    board[row][col] = 1;
            }
        }
    }

    private int liveNeighbors(int row, int col, int[][] board) {
        final int NR = board.length, NC = board[0].length;

        int lives = 0;

        for (final int[] DIR : DIRS) {
            int nextRow = row + DIR[0], nextCol = col + DIR[1];
            if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC)
                continue;
            if (board[nextRow][nextCol] == 1 || board[nextRow][nextCol] == STATE_DEAD)
                ++lives;
        }
        return lives;
    }
}