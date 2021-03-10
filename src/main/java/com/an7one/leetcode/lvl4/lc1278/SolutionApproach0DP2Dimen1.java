/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 * 
 * Time Complexity:     O(L * K * L) ~ O(L ^ 3)
 * Space Compelxity:    O(L * K) ~ O(L ^ 2)
 * 
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning-iii/discuss/470372/Easy-dynamic-programming-solution/542795
 *  https://www.youtube.com/watch?v=kD6ShM6jr3g
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1278-palindrome-partitioning-iii/
 */
package com.an7one.leetcode.lvl4.lc1278;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen1 {
    public int palindromePartition(String s, int K) {
        final int L = s.length();
        
        int[][] costs = new int[L][L];
        // for substring s[i : j] (both ends inclusive)
        for(int j = 0; j < L; ++j){
            for(int i = j; i >= 0; --i){
                costs[i][j] = s.charAt(i) != s.charAt(j) ? 1 : 0;
                if(j - i > 2){
                    costs[i][j] += costs[i + 1][j - 1];
                }
            }
        }
        
        int[][] dp = new int[L + 1][K + 1];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[L][K] = 0;
        
        for(int i = L - 1; i >= 0; --i){
            for(int k = K - 1; k >= 0; --k){
                for(int j = i; j < L; ++j){
                    if(dp[j + 1][k + 1] == Integer.MAX_VALUE) continue;
                    dp[i][k] = Math.min(dp[i][k], dp[j + 1][k + 1] + costs[i][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}