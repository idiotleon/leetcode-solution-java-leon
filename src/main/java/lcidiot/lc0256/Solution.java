/**
 * https://leetcode.com/problems/paint-house/
 */
package main.java.lcidiot.lc0256;

public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        
        final int N = costs.length - 1;
        return Math.min(Math.min(costs[N][0], costs[N][1]), costs[N][2]);
    }
}