/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * to push forward
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number-ii/discuss/69364/My-16ms-C%2B%2B-DP-solution-with-short-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0264;

public class SolutionApproach0DP {
    public int nthUglyNumber(int n) {
        // sanity check
        if(n <= 0) return 0;
        
        int factor2 = 0, factor3 = 0, factor5 = 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[factor2] * 2, Math.min(dp[factor3] * 3, dp[factor5] * 5));
            if(dp[i] == dp[factor2] * 2) factor2++;
            if(dp[i] == dp[factor3] * 3) factor3++;
            if(dp[i] == dp[factor5] * 5) factor5++;
        }
        
        return dp[n - 1];
    }
}