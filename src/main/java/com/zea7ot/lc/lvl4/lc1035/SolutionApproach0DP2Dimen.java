/**
 * https://leetcode.com/problems/uncrossed-lines/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/uncrossed-lines/discuss/282842/JavaC%2B%2BPython-DP-The-Longest-Common-Subsequence
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/longest-common-subsequence/
 */
package com.zea7ot.lc.lvl4.lc1035;

public class SolutionApproach0DP2Dimen {
    public int maxUncrossedLines(int[] A, int[] B) {
        // sanity check
        if(A == null || B == null || A.length == 0 || B.length == 0) return 0;

        final int LEN_A = A.length, LEN_B = B.length;
        int[][] dp = new int[LEN_A + 1][LEN_B + 1];
        for(int i = 1; i <= LEN_A; ++i){
            for(int j = 1; j <= LEN_B; ++j){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[LEN_A][LEN_B];
    }
}