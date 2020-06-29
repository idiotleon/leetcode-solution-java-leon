/**
 * 
 */
package com.zea7ot.lc.lvl3.lc1155;

public class SolutionApproach0DFSMemo1 {
    private static final int MOD = (int)(1e9 + 7);
    private int[][] memo = new int[31][1001];
    
    public int numRollsToTarget(int d, int f, int target) {
        if(d == 0 && target == 0) return 1;
        if(d > target || d * f < target) return 0;
        // not pruning enough than the above
        // if(d == 0 || target <= 0) return 0;
        
        if(memo[d][target] > 0) return memo[d][target] - 1;
        int count = 0;
        for(int i = 1; i <= f; ++i){
            count = (count + numRollsToTarget(d - 1, f, target - i)) % MOD;
        }
        memo[d][target] = count + 1;
        
        return count;
    }
}