/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
package com.zea7ot.leetcode.lvl4.lc0073;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    if(row == 0) firstRow = true;
                    if(col == 0) firstCol = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        
        if(firstRow){
            for(int col = 0; col < matrix[0].length; col++){
                matrix[0][col] = 0;
            }
        }
        
        if(firstCol){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;
            }
        }
   }
}