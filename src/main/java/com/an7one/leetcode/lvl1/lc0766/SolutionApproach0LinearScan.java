/**
 * https://leetcode.com/problems/toeplitz-matrix/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/toeplitz-matrix/discuss/113417/Java-solution-4-liner.
 */
package com.an7one.leetcode.lvl1.lc0766;

public class SolutionApproach0LinearScan {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;
        for(int row = 0; row < NR - 1; ++row){
            for(int col = 0; col < NC - 1; ++col){
                if(matrix[row][col] != matrix[row + 1][col + 1])
                    return false;
            }
        }
        
        return true;
    }
}