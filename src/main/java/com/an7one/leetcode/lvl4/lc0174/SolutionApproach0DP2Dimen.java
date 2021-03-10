/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 *  or O(1) if one modifying the original array
 * 
 * References:
 *  https://leetcode.com/problems/dungeon-game/discuss/52774/C%2B%2B-DP-solution
 *  https://leetcode.com/problems/dungeon-game/discuss/52774/C++-DP-solution/53813
 */
package com.an7one.leetcode.lvl4.lc0174;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int calculateMinimumHP(int[][] dungeon) {
        final int NR = dungeon.length, NC = dungeon[0].length;

        // dp[row][col] represents the mininum need at position (row, col)
        int[][] dp = new int[NR + 1][NC + 1];
        // to add dummy row and column at the bottom and rightmost,
        // or to initialize the whole matrix
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[NR][NC - 1] = 1;
        dp[NR - 1][NC] = 1;

        for (int row = NR - 1; row >= 0; row--) {
            for (int col = NC - 1; col >= 0; col--) {
                int need = Math.min(dp[row + 1][col], dp[row][col + 1]) - dungeon[row][col];
                // if the need is negative,
                // which means the health is positive.
                // https://leetcode.com/problems/dungeon-game/discuss/52774/C++-DP-solution/53813
                dp[row][col] = need <= 0 ? 1 : need;
                // equivalently
                // dp[row][col] = Math.max(need, 1);
            }
        }

        return dp[0][0];
    }
}