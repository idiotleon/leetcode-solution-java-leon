/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution
 */
package com.zea7ot.lc.lvl3.lc0256;

public class SolutionAppraoch0DP {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        final int N = costs.length;
        int color0 = 0, color1 = 0, color2 = 0;
        for(int i = 0; i < N; i++){
            int tempColor0 = color0, tempColor1 = color1, tempColor2 = color2;
            color0 = costs[i][0] + Math.min(tempColor1, tempColor2);
            color1 = costs[i][1] + Math.min(tempColor0, tempColor2);
            color2 = costs[i][2] + Math.min(tempColor0, tempColor1);
        }
        
        return Math.min(color0, Math.min(color1, color2));
    }
}