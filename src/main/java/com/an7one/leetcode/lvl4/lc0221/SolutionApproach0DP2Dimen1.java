/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
package com.an7one.leetcode.lvl4.lc0221;

public class SolutionApproach0DP2Dimen1 {
    public int maximalSquare(char[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        int[][] prefixSums = new int[NR][NC];
        for(int row = 0; row < NR; row++) prefixSums[row][0] = matrix[row][0] - '0';
        for(int col = 0; col < NC; col++) prefixSums[0][col] = matrix[0][col] - '0';
        
        for(int row = 1; row < NR; row++){
            for(int col = 1; col < NC; col++){
                if(matrix[row][col] == '1'){
                    prefixSums[row][col] = Math.min(Math.min(prefixSums[row][col - 1], prefixSums[row - 1][col]), prefixSums[row - 1][col - 1]) + 1;
                }else prefixSums[row][col] = 0;
            }
        }
        
        // to acquire the `maxLen` is a must, compared to acquisition in the above for loop,
        // because the `maxLen` might appear on the first row or column,
        // where the above for loop does NOT cover
        int maxLen = prefixSums[0][0];
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                maxLen = Math.max(maxLen, prefixSums[row][col]);
            }
        }
        
        return maxLen * maxLen;
    }
}