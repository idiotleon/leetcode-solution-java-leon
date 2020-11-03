/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NC)
 * 
 * References:
 *  https://leetcode.com/problems/dungeon-game/discuss/52826/A-very-clean-and-intuitive-solution-(with-explanation)
 *  https://leetcode.com/problems/dungeon-game/discuss/52897/My-java-solution-with-explanation-in-detail/53923
 *  https://leetcode.com/problems/dungeon-game/discuss/52826/A-very-clean-and-intuitive-solution-(with-explanation)
 */
package com.zea7ot.leetcode.lvl4.lc0174;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen1 {
    public int calculateMinimumHP(int[][] dungeon) {
        final int NR = dungeon.length, NC = dungeon[0].length;

        int[] dp = new int[NC + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[NC - 1] = 0;
        for (int row = NR - 1; row >= 0; row--) {
            for (int col = NC - 1; col >= 0; col--) {
                dp[col] = Math.min(dp[col], dp[col + 1]) - dungeon[row][col];
                dp[col] = Math.max(dp[col], 0);
            }
        }

        return dp[0] + 1;
    }
}