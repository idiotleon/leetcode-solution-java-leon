/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
package com.polyg7ot.lc.lvl4.lc0059;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0) return matrix;
        
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;
        
        while(true){
            for(int col = left; col <= right; col++){
                matrix[top][col] = num++;
            }
            top++;
            if(left > right || top > bottom) break;
            
            for(int row = top; row <= bottom; row++){
                matrix[row][right] = num++;
            }
            right--;
            if(left > right || top > bottom) break;
            
            for(int col = right; col >= left; col--){
                matrix[bottom][col] = num++;
            }
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int row = bottom; row >= top; row--){
                matrix[row][left] = num++;
            }
            left++;
            if(left > right || top > bottom) break;
        }
        
        return matrix;
    }
}