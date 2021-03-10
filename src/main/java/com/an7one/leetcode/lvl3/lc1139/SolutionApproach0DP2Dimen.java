/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 * 
 * Time Complexity:     O(NR * NC * min(NR, NC))
 * Space Complexity:    O(NR * NC * 2) ~ O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/largest-1-bordered-square/discuss/345233/JavaC%2B%2BPython-Straight-Forward
 */
package com.an7one.leetcode.lvl3.lc1139;

public class SolutionApproach0DP2Dimen {
    public int largest1BorderedSquare(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;
        
        final int NR = grid.length, NC = grid[0].length;
        int[][] leftToRight = new int[NR][NC];
        int[][] topToDown = new int[NR][NC];
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] > 0){
                    leftToRight[row][col] = col > 0 ? leftToRight[row][col - 1] + 1 : 1;
                    topToDown[row][col] = row > 0 ? topToDown[row - 1][col] + 1 : 1;
                }
            }
        }
        
        int maxLen = Math.min(NR, NC);
        while(maxLen > 0){
            for(int row = 0; row < NR - maxLen + 1; row++){
                for(int col = 0; col < NC - maxLen + 1; col++){
                    if(grid[row][col] == 0) continue;
                    // to check all 4 sides
                    if(topToDown[row + (maxLen - 1)][col] < maxLen) continue; 
                    if(topToDown[row + (maxLen - 1)][col + (maxLen - 1)] < maxLen) continue; 
                    if(leftToRight[row][col + (maxLen - 1)] < maxLen) continue;  
                    if(leftToRight[row + (maxLen - 1)][col + (maxLen - 1)] < maxLen) continue;

                    return maxLen * maxLen;
                }
            }

            maxLen--;
        }
        
        return 0;
    }
}