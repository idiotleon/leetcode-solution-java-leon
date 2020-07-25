/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 * 
 * Time Complexity:     O(N * RANGE)
 * Space Complexity:    O(N * RANGE)
 * 
 * References:
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/294888/JavaC++Python-Easy-Knapsacks-DP/393908
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/295167/Java-beat-100-with-nice-explanation
 */
package com.zea7ot.lc.lvl4.lc1049;

public class SolutionApproach0Knapsack1 {
    public int lastStoneWeightII(int[] stones) {
        final int N = stones.length;
        int sum = 0;
        for(int stone : stones) sum += stone;
        final int RANGE = sum / 2;
        int[][] dp = new int[N + 1][RANGE + 1];
        
        for(int i = 1; i <= N; ++i){
            for(int j = 0; j <= RANGE; ++j){
                if(j >= stones[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return sum - 2 * dp[N][RANGE];
    }
}