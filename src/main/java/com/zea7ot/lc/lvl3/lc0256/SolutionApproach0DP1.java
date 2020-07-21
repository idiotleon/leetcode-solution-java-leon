/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68203/Share-my-very-simple-Java-solution-with-explanation.
 */
package com.zea7ot.lc.lvl3.lc0256;

public class SolutionApproach0DP1 {
    public int minCost(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0) return 0;
        
        final int N = costs.length;
        int lastColor0 = costs[0][0];
        int lastColor1 = costs[0][1];
        int lastColor2 = costs[0][2];
        
        for(int i = 1; i < N; i++){
            int color0 = costs[i][0] + Math.min(lastColor1, lastColor2);
            int color1 = costs[i][1] + Math.min(lastColor0, lastColor2);
            int color2 = costs[i][2] + Math.min(lastColor0, lastColor1);
            
            lastColor0 = color0;
            lastColor1 = color1;
            lastColor2 = color2;
        }
        
        return Math.min(lastColor0, Math.min(lastColor1, lastColor2));
    }
}