/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * `dp[i]`, minimum height to place `books[0]` ~ `books[i]`
 * dp[j] = min{dp[i - 1] + H}, 0 < i < j
 *  H = max(height[i ~ j]), given that sum(width[i ~ j]) <= maxWidth
 * ans: dp[N - 1]
 * 
 * the "pull" approach
 * 
 * References:
 *  https://www.youtube.com/watch?v=a7TLEVdqg0Q
 */
package com.idiotleon.leetcode.lvl4.lc1105;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen2 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int N = books.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int j = 0; j < N; ++j) {
            int width = 0;
            int height = 0;
            for (int i = j; i >= 0; --i) {
                if ((width += books[i][0]) > shelfWidth)
                    break;
                height = Math.max(height, books[j][1]);
                dp[j] = Math.min(dp[j], (i == 0 ? 0 : dp[i - 1]) + height);
            }
        }

        return dp[N - 1];
    }
}