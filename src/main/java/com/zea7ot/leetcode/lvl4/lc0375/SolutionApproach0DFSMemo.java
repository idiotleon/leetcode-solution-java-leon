/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84778/Recursion-%2B-Memization
 */
package com.zea7ot.leetcode.lvl4.lc0375;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        for(int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
        return dfs(1, n, memo);
    }
    
    private int dfs(int lo, int hi, int[][] memo){
        if(lo >= hi) return 0;
        if(memo[lo][hi] != Integer.MAX_VALUE) return memo[lo][hi];
        for(int k = lo; k <= hi; ++k){
            memo[lo][hi] = Math.min(memo[lo][hi], Math.max(k + dfs(lo, k - 1, memo), k + dfs(k + 1, hi, memo)));
        }
        
        return memo[lo][hi];
    }
}