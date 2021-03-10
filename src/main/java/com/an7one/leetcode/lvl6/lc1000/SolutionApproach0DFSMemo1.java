/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O((N ^ 2) * K)
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
 *  https://www.youtube.com/watch?v=FabkoUzs64o
 */
package com.an7one.leetcode.lvl6.lc1000;

import java.util.Arrays;

public class SolutionApproach0DFSMemo1 {
    public int mergeStones(int[] stones, int K) {
        final int N = stones.length;
        if((N - 1) % (K - 1) != 0) return -1;
        
        int[] prefixSums = new int[N + 1];
        for(int i = 0; i < N; ++i)
            prefixSums[i + 1] = prefixSums[i] + stones[i];
        
        int[][][] memo = new int[N][N][K + 1];
        for(int[][] matrix : memo)
            for(int[] row : matrix)
                Arrays.fill(row, Integer.MAX_VALUE);
        
        return dfs(0, N - 1, 1, prefixSums, K, memo);
    }
    
    private int dfs(int i, int j, int k, 
                    int[] prefixSums, 
                    int K, 
                    int[][][] memo){
        if((j - i + 1 - k) % (K - 1) != 0) return Integer.MAX_VALUE;
        if(i == j) return k == 1 ? 0 : Integer.MAX_VALUE;
        if(memo[i][j][k] != Integer.MAX_VALUE) return memo[i][j][k];
        
        if(k == 1)
            return memo[i][j][k] = dfs(i, j, K, prefixSums, K, memo) + prefixSums[j + 1] - prefixSums[i];
        
        int res = Integer.MAX_VALUE;
        for(int m = i; m < j; m += K - 1){
            int lo = dfs(i, m, 1, prefixSums, K, memo);
            if(lo >= res) continue;
            int hi = dfs(m + 1, j, k - 1, prefixSums, K, memo);
            if(hi >= res) continue;
            res = Math.min(res, lo + hi);
        }
        
        return memo[i][j][k] = res;
    }
}