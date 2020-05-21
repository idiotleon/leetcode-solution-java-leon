/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 * 
 * Time Complexity: O(NR * NC)
 * Space Complexity: O(NR * NC)
 * 
 * References:
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/discuss/452666/Easy-Java-optimized-prefix-sum-one-pass-O(mn)
 */
package com.polyg7ot.lc.lvl4.lc1292;

public class SolutionApproach0OnePass {
    public int maxSideLength(int[][] matrix, int threshold) {
        final int NR = matrix.length, NC = matrix[0].length;
        
        int max = 0;
        int[][] prefixSum = new int[NR + 1][NC + 1];
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                prefixSum[row + 1][col + 1] = matrix[row][col] + prefixSum[row + 1][col] + prefixSum[row][col + 1] - prefixSum[row][col];
                
                if(row - max >= 0 
                   && col - max >= 0 
                   && prefixSum[row + 1][col + 1] - prefixSum[row - max][col + 1] - prefixSum[row + 1][col - max] + prefixSum[row - max][col - max] <= threshold){
                    max += 1;
                }
            }
        }
        
        return max;
    }
}