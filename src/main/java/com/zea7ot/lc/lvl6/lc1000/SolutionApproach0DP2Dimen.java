/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * 
 * Time Complexity:     O((N ^ 3) / K)
 * Space Complexity:    O(N ^ 2)
 * 
 * 
 * `dp[len][i]`, min cost to merge [i, i + len) into as less piles as possible.
 *      Number of merges will be `(len - 1) / (K - 1)`.
 * 
 * Transition:
 *  dp[len][i] = min(dp[m][i] + dp[len - m][i + m] for 1 <= m < len if((len - 1) % (K - 1) == 0) can be merged into 1 pile, 
 *                   dp[len][i] += sum(nums[i : i + len])
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
 *  https://www.youtube.com/watch?v=FabkoUzs64o
 *  https://youtu.be/FLbqgyJ-70I?t=8074
 */
package com.zea7ot.lc.lvl6.lc1000;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int mergeStones(int[] stones, int K) {
        final int N = stones.length;
        if((N - 1) % (K - 1) != 0) return -1;
        
        int[] prefixSums = new int[N + 1];
        for(int i = 0; i < N; ++i)
            prefixSums[i + 1] = prefixSums[i] + stones[i];
        
        int[][] dp = new int[N][N];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        for(int i = 0; i < N; ++i) dp[i][i] = 0;
        
        for(int len = 2; len <= N; ++len){
            for(int i = 0; i <= N - len; ++i){
                int j = i + len - 1;
                for(int m = i; m < j; m += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                
                if((len - 1) % (K - 1) == 0)
                    dp[i][j] += prefixSums[j + 1] - prefixSums[i];
            }
        }
        
        return dp[0][N - 1];
    }
}