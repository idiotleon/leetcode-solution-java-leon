/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * Time Complexity:     O(NR * NC) ~ O(N * K)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 */
package com.zea7ot.leetcode.lvl4.lc0265;

public class SolutionApproach0DP {
    public int minCostII(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        final int NR = costs.length, NC = costs[0].length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int colMin1 = -1;
        for(int col = 0; col < NC; ++col){
            if(costs[0][col] < min1){
                colMin1 = col;
                min2 = min1;
                min1 = costs[0][col];
            }else if(costs[0][col] < min2){
                min2 = costs[0][col];
            }
        }
        
        for(int row = 1; row < NR; ++row){
            int last1 = min1, last2 = min2, colLast = colMin1;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            
            for(int col = 0; col < NC; ++col){
                int val = 0;
                if(col != colLast){
                    val = last1 + costs[row][col];
                }else{
                    val = last2 + costs[row][col];
                }
                
                if(val < min1){
                    colMin1 = col;
                    min2 = min1;
                    min1 = val;
                }else if(val < min2){
                    min2 = val;
                }
            }
        }
        
        return min1;
    }
}