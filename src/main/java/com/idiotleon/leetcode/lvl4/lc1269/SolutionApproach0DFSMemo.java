/**
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * 
 * Time Complexity:     O(steps ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/discuss/436117/C%2B%2B-Recursive-DP-(Memoization)
 */
package com.idiotleon.leetcode.lvl4.lc1269;

public class SolutionApproach0DFSMemo {
    private static final int MOD = (int)1e9 + 7;
    
    public int numWays(int steps, int arrLen) {
        int[][] memo = new int[steps + 1][501];
        return dfs(steps, arrLen, 0, memo);
    }
    
    private int dfs(int steps, int len, int idx, int[][] memo){
        if(steps == 0) return idx == 0 ? 1 : 0;
        
        if(memo[steps][idx] != 0) return memo[steps][idx] - 1;
        int res = 0;
        
        // left
        if(idx > 0)
            res = (res + dfs(steps - 1, len, idx - 1, memo)) % MOD;
        
        // right
        if(idx < len - 1)
            res = (res + dfs(steps - 1, len, idx + 1, memo)) % MOD;
        
        // stay
        res = (res + (dfs(steps - 1, len, idx, memo))) % MOD;
        
        memo[steps][idx] = res + 1;
        return res;
    }
}