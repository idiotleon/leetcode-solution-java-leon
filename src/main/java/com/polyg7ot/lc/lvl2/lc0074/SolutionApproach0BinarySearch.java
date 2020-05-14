/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl2.lc0074;

public class SolutionApproach0BinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        // boundaries
        final int NR = matrix.length, NC = matrix[0].length;
        
        int left = 0, right = NR * NC - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int cur = matrix[mid / NC][mid % NC];
            
            if(cur == target) return true;
            else if(cur > target) right = mid - 1;
            else left = mid + 1;
        }
        
        return false;
    }
}