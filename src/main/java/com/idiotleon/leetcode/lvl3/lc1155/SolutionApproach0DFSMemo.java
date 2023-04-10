/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 * Time Complexity:     O(d * f * target)
 * Space Complexity:    O(d * target)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355940/C%2B%2B-Coin-Change-2
 */
package com.idiotleon.leetcode.lvl3.lc1155;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    private final int MOD = (int)(1e9 + 7);
    
    public int numRollsToTarget(int d, int f, int target) {
        int[][] memo = new int[31][1001];
        for(int[] row : memo) Arrays.fill(row, -1);
        return dfs(d, f, target, memo);
    }
    
    private int dfs(int d, int f, int target, int[][] memo){
        if(d == 0 && target == 0) return 1;
        if(d > target || d * f < target) return 0;
        
        if(memo[d][target] != -1) return memo[d][target];
        int count = 0;
        for(int i = 1; i <= f; i++){
            count = (count + dfs(d - 1, f, target - i, memo)) % MOD;
        }
        return memo[d][target] = count;
    }
}