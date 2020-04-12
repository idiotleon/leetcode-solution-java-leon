/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
package main.java.lcidiot.lc0240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity check
        if(matrix == null || matrix.length == 0) return false;
        
        int row = matrix.length - 1, col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target) row--;
            else if(matrix[row][col] < target) col++;
            else return true;
        }
        
        return false;
    }
}