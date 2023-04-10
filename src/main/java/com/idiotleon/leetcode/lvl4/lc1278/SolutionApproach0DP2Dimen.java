/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * 
 * State / Subproblems:
 *  1. length `i`: relies on length `j` (j < i)
 *  2. groups `k`: relies on `k - 1` groups
 * 
 * `dp[i][k]`, min cost to make `k` strings using the first `i` letters
 *  for each subproblem, it takes O(L) time to try all possible partitions.
 * 
 * Transition:
 *  dp[i][k] = min{dp[j][k - 1] + cost(j + 1, i)}
 *  minimum changes to make s[0 : i] into k palindrome
 * 
 * Initialization: 
 *  dp[i][1] = cost(0, i)
 *      dp[i][1], to take all `i`s into ONE partition/group
 * 
 * Answer:
 *  dp[L - 1][K]
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=kD6ShM6jr3g
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1278-palindrome-partitioning-iii/
 *  https://youtu.be/FLbqgyJ-70I?t=5664
 */
package com.idiotleon.leetcode.lvl4.lc1278;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int palindromePartition(String s, int K) {
        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int[][] costs = new int[L][L];
        for (int len = 2; len <= L; ++len) {
            for (int i = 0, j = len - 1; j < L; ++i, ++j)
                costs[i][j] = (CHS[i] == CHS[j] ? 0 : 1) + costs[i + 1][j - 1];
        }

        int[][] dp = new int[L][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        for (int len = 0; len < L; ++len) {
            dp[len][1] = costs[0][len];
            for (int k = 2; k <= K; ++k) {
                for (int sub = 0; sub < len; ++sub) {
                    dp[len][k] = Math.min(dp[len][k], dp[sub][k - 1] + costs[sub + 1][len]);
                }
            }
        }

        return dp[L - 1][K];
    }
}