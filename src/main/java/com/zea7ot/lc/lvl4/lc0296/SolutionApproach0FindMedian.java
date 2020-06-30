/**
 * https://leetcode.com/problems/best-meeting-point/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR) + O(NC)
 * 
 * References:
 *  https://leetcode.com/problems/best-meeting-point/discuss/74193/Java-2msPython-40ms-two-pointers-solution-no-median-no-sort-with-explanation
 */
package com.zea7ot.lc.lvl4.lc0296;

public class SolutionApproach0FindMedian {
    public int minTotalDistance(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        int[] rowSums = new int[NC], colSums = new int[NR];
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                rowSums[col] += grid[row][col];
                colSums[row] += grid[row][col];
            }
        }
        
        return minDistance(rowSums) + minDistance(colSums);
    }
    
    private int minDistance(int[] sums){
        int lo = -1, hi = sums.length;
        int distance = 0, left = 0, right = 0;
        while(lo < hi){
            if(left < right){
                distance += left;
                left += sums[++lo];
            }else{
                distance += right;
                right += sums[--hi];
            }
        }
        
        return distance;
    }
}