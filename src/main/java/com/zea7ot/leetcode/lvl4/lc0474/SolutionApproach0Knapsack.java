/**
 * https://leetcode.com/problems/ones-and-zeroes/
 * 
 * Time Complexity:     O(N * m * n)
 * Space Complexity:    O(m * n)
 * 
 * `dp[i][j]`, the maximum number of string(s) used to form `i` 0s and `j` `s
 * 
 * References:
 *  https://leetcode.com/problems/ones-and-zeroes/discuss/95807/0-1-knapsack-detailed-explanation./100314
 *  https://leetcode.com/problems/ones-and-zeroes/discuss/95811/Java-Iterative-DP-Solution-O(mn)-Space/100335
 */
package com.zea7ot.leetcode.lvl4.lc0474;

public class SolutionApproach0Knapsack {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            final int[] count = new int[2];
            for(char ch : str.toCharArray()) ++count[ch - '0'];
            
            int zeros = count[0], ones = count[1];
            for(int i = m; i >= zeros; --i){
                for(int j = n; j >= ones; --j){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}