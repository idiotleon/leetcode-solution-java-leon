package com.idiotleon.leetcode.lvl3.lc0723;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/candy-crush/
 * <p>
 * Time Complexity:     O(NR * NC * (NR * NC - 2)) ~ O((NR * NC) ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/candy-crush/discuss/178366/Another-Java-Solution
 * https://leetcode.com/problems/candy-crush/discuss/178366/Another-Java-Solution/412311
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    public int[][] candyCrush(int[][] board) {
        final int NR = board.length, NC = board[0].length;
        boolean shouldContinue = false;

        // to crush candies horizontally
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC - 2; ++col) {
                int candy = Math.abs(board[row][col]);
                if (candy > 0 && candy == Math.abs(board[row][col + 1]) && candy == Math.abs(board[row][col + 2])) {
                    board[row][col] = board[row][col + 1] = board[row][col + 2] = -candy;
                    shouldContinue = true;
                }
            }
        }

        // to crush candies vertically
        for (int col = 0; col < NC; ++col) {
            for (int row = 0; row < NR - 2; ++row) {
                int candy = Math.abs(board[row][col]);
                if (candy > 0 && candy == Math.abs(board[row + 1][col]) && candy == Math.abs(board[row + 2][col])) {
                    board[row][col] = board[row + 1][col] = board[row + 2][col] = -candy;
                    shouldContinue = true;
                }
            }
        }

        // to evicted out the empty spaces, represented by negative values, created by
        // the crushes
        // to drop the candies column by column, bottom to top
        for (int col = 0; col < NC; ++col) {
            // to start with the very bottom
            int r = NR - 1;
            // to pile up the candies left on the very column
            for (int row = NR - 1; row >= 0; --row)
                // if it is positive, there is a candy
                if (board[row][col] > 0)
                    board[r--][col] = board[row][col];

            // to clear up the rest/top
            for (int row = r; row >= 0; --row)
                board[row][col] = 0;
        }

        return shouldContinue ? candyCrush(board) : board;
    }
}