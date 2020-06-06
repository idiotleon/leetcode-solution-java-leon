/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Time Complexity:     O(amount ^ N / (coin0 * coin1 * ... * coinN))
 * Space Complexity:    O(N)
 * 
 * Greedy, to use coins of the largest nominal values if possible
 * Pruning, to skip searches that exceeds the current minimum coins
 * 
 * Since there is no easy way to sort an array of primitive integer in descending order,
 * to use coins of the largest nomila values if possible,
 * coins are taken from the tail to the head of the sorted coins array
 * 
 * References:
 *  https://www.youtube.com/watch?v=uUETHdijzkA
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
package com.zea7ot.lc.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach0DFSGreedyPruning {
    private int ans;
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        final int N = coins.length;
        
        this.ans = Integer.MAX_VALUE;
        dfs(coins, N - 1, amount, 0);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void dfs(final int[] coins, int idx, int amount, int count){
        if(amount == 0){
            ans = Math.min(ans, count);
            return;
        }
        
        // (idx == 0) is a valid index
        if(idx < 0) return;
        
        // greedy: to take coins of the largest nominal value if possible
        final int coin = coins[idx];
        // pruning: count + k < ans
        for(int k = amount / coin; k >= 0 && count + k < ans; k--){
            dfs(coins, idx - 1, amount - k * coin, count + k);
        }
    }
}