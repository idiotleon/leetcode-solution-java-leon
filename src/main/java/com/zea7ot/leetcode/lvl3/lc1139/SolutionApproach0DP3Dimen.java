/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 * 
 * Time Complexity:     O(NR * NC * min(NR, NC))
 * Space Complexity:    O(NR * NC * 2) ~ O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/largest-1-bordered-square/discuss/345574/Java-DP-Solution-with-Videos-Explained
 */
package com.zea7ot.leetcode.lvl3.lc1139;

public class SolutionApproach0DP3Dimen {
    public int largest1BorderedSquare(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;
        
        final int NR = grid.length, NC = grid[0].length;
        int[][][] dp = new int[NR + 1][NC + 1][2];
        int max = 0;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    // left - right
                    dp[row + 1][col + 1][0] = dp[row][col + 1][0] + 1;
                    // top - down
                    dp[row + 1][col + 1][1] = dp[row + 1][col][1] + 1;
                        
                    int len = Math.min(dp[row + 1][col + 1][0], dp[row + 1][col + 1][1]);
                    for(int k = len; k > max; k--){
                        int leftTopMinLen = Math.min(dp[row + 1 - (k - 1)][col + 1][1], dp[row + 1][col + 1 - (k - 1)][0]);
                        if(leftTopMinLen >= k) max = Math.max(max, k);
                    }
                }else{
                    dp[row + 1][col + 1][0] = 0;
                    dp[row + 1][col + 1][1] = 0;
                }
            }
        }
        
        return max * max;
    }
}