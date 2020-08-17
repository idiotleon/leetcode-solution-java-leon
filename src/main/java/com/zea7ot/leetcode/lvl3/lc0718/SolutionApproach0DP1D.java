/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * 
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(LEN(B))
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109068/JavaC%2B%2B-Clean-Code-8-lines
 */
package com.zea7ot.leetcode.lvl3.lc0718;

public class SolutionApproach0DP1D {
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null) return 0;
        final int M = A.length, N = B.length;
        int max = 0;
        
        int[] dp = new int[N + 1];
        for(int i = M - 1; i >= 0; i--){
            for(int j = 0; j < N; j++){
                max = Math.max(max, dp[j] = A[i] == B[j] ? 1 + dp[j + 1] : 0);
            }
        }
        
        return max;
    }
}