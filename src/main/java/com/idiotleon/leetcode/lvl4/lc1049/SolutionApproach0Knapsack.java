/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 * 
 * Time Complexity:     O(N * RANGE)
 * Space Complexity:    O(RANGE)
 * 
 * to divide the stones into two groups, such that the difference of the sum of weights of each group is minimum
 * 
 * `dp[j]`, the best value one can get with a knapsack of `j` using `i` stones in the outer loop
 * 
 * 
 * 
 * References:
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/294888/JavaC%2B%2BPython-Easy-Knapsacks-DP
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/296350/Explaining-why-this-problem-is-equals-to-finding-the-difference-between-the-sum-of-two-groups/433216
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/295325/Why-DP-is-applicable-here
 *  https://www.youtube.com/watch?v=8LusJS5-AGo
 *  https://leetcode.com/problems/last-stone-weight-ii/discuss/295167/Java-beat-100-with-nice-explanation
 */
package com.idiotleon.leetcode.lvl4.lc1049;

public class SolutionApproach0Knapsack {
    public int lastStoneWeightII(int[] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return 0;
        
        int sum = 0;
        for(int stone : stones) sum += stone;
        final int RANGE = sum / 2, N = stones.length;
        
        int[] dp = new int[RANGE + 1];
        
        for(int i = 0; i < N; ++i){
            for(int weight = RANGE; weight >= stones[i]; --weight){
                dp[weight] = Math.max(dp[weight], dp[weight - stones[i]] + stones[i]);
            }
        }
        
        return sum - 2 * dp[RANGE];
    }
}