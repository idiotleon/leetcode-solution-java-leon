/**
 * https://leetcode.com/problems/maximum-students-taking-exam/
 * 
 * Time Complexity:     O(NR * (4 ^ NC))
 * Space Complexity:    O(NR * (2 ^ NC))
 * 
 * References:
 *  https://leetcode.com/problems/maximum-students-taking-exam/discuss/503686/A-simple-tutorial-on-this-bitmasking-problem/446603
 *  https://leetcode.com/problems/maximum-students-taking-exam/discuss/503686/A-simple-tutorial-on-this-bitmasking-problem
 */
package com.an7one.leetcode.lvl5.lc1349;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int maxStudents(char[][] seats) {
        final int NR = seats.length, NC = seats[0].length;
        int[] validRows = new int[NR];

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                validRows[row] = (validRows[row] << 1) + (seats[row][col] == '.' ? 1 : 0);
            }
        }

        final int RANGE_STATE = 1 << NC;
        int[][] dp = new int[NR][RANGE_STATE];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < RANGE_STATE; ++col) {
                // (col & validRows[row]) == col: to check if `col` is a subset of
                // `validRows[row]`
                // !(col & (col >> 1)): to check if there is no adjacent students in the row
                if (((col & validRows[row]) == col) && ((col & (col >> 1)) == 0)) {
                    if (row == 0) {
                        dp[row][col] = Integer.bitCount(col);
                    } else {
                        for (int k = 0; k < RANGE_STATE; ++k) {
                            // !(col & (k >> 1)): no students in the upper left positions
                            // !((col >> 1) & k): no students in the upper right positions
                            // dp[row - 1][k] != -1: the previous state is valid
                            if ((col & (k >> 1)) == 0 && ((col >> 1) & k) == 0 && dp[row - 1][k] != -1) {
                                dp[row][col] = Math.max(dp[row][col], dp[row - 1][k] + Integer.bitCount(col));
                            }
                        }
                    }

                    ans = Math.max(ans, dp[row][col]);
                }
            }
        }

        return ans;
    }
}
