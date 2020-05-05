/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl3.lc0256;

public class SolutionApproachDP {
    public int minCost(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0) return 0;
        
        final int L = costs.length;
        for(int i = 1; i < L; i++){
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        
        return Math.min(Math.min(costs[L - 1][0], costs[L - 1][1]), costs[L - 1][2]);
    }
}