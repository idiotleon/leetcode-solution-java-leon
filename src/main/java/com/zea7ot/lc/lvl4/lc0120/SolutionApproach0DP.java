/**
 * https://leetcode.com/problems/triangle/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR)
 */
package com.zea7ot.lc.lvl4.lc0120;

import java.util.List;

public class SolutionApproach0DP {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int NR = triangle.size();
        int[] dp = new int[NR + 1];
        
        for(int row = NR - 1; row >= 0; row--){
            List<Integer> curRow = triangle.get(row);
            final int NC = curRow.size();

            for(int col = 0; col < NC; col++){
                dp[col] = Math.min(dp[col], dp[col + 1]) + curRow.get(col);
            }
        }
        
        return dp[0];
    }
}