/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 * 
 * Time Complexity:     O(N * HALF)
 * Space Complexity:    O(HALF)
 * 
 * to divide the stones into two groups, such that the difference of the sum of weights of each group is minimum
 * 
 * References:
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/296350/Explaining-why-this-problem-is-equals-to-finding-the-difference-between-the-sum-of-two-groups/433216
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/295325/Why-DP-is-applicable-here
 *  https://www.youtube.com/watch?v=8LusJS5-AGo
 */
package com.zea7ot.lc.lvl4.lc1049;

public class SolutionApproach0Knapsack {
    public int lastStoneWeightII(int[] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return 0;
        
        int sum = 0;
        for(int stone : stones) sum += stone;
        final int HALF = sum / 2, L = stones.length;
        
        int[] dp = new int[HALF + 1];
        
        for(int i = 0; i < L; i++){
            for(int weight = HALF; weight >= stones[i]; weight--){
                dp[weight] = Math.max(dp[weight], dp[weight - stones[i]] + stones[i]);
            }
        }
        
        return sum - 2 * dp[HALF];
    }
}