/**
 * https://leetcode.com/problems/paint-fence/
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/paint-fence/discuss/178010/The-only-solution-you-need-to-read
 *  https://youtu.be/FLbqgyJ-70I?t=1430
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_331
 */
package com.zea7ot.leetcode.lvl3.lc0276;

public class SolutionApproach0DP3 {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k * k;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        
        return dp[n];
    }
}