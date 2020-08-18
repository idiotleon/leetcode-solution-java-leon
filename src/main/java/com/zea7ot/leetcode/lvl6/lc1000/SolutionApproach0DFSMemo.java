/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * 
 * Time Complexity:     O((N ^ 3) / K)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
 *  https://www.youtube.com/watch?v=FabkoUzs64o
 */
package com.zea7ot.leetcode.lvl6.lc1000;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    public int mergeStones(int[] stones, int K) {
        final int N = stones.length;
        if((N - K) % (K - 1) != 0) return -1;
        
        int[][] memo = new int[N][N];
        for(int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
        int[] prefixSums = new int[N + 1];
        for(int i = 0; i < N; ++i)
            prefixSums[i + 1] = prefixSums[i] + stones[i];
        
        return dfs(0, N - 1, prefixSums, K, memo);
    }
    
    private int dfs(int i, int j, int[] prefixSums, int K, int[][] memo){
        final int LEN = j - i + 1;
        if(LEN < K) return 0;
        if(memo[i][j] != Integer.MAX_VALUE) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for(int m = i; m < j; m += K - 1)
            res = Math.min(res, dfs(i, m, prefixSums, K, memo) + dfs(m + 1, j, prefixSums, K, memo));
        
        if((LEN - 1) % (K - 1) == 0)
            res += prefixSums[j + 1] - prefixSums[i];
        
        return memo[i][j] = res;
    }
}