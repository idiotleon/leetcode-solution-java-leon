/**
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions
 */
package com.an7one.leetcode.lvl1.lc0509;

public class SolutionApproach0DP {
    public int fib(int N) {
        if(N <= 1)
            return N;
        
        int[] dp = new int[N + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= N; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[N];
    }
}