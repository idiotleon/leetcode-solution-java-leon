/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(1)
 * 
 * Based on Binary Search - Hermann
 */
package com.idiotleon.leetcode.lvl2.lc0074;

public class SolutionApproach1BinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity check
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        // boundaries
        final int NR = matrix.length, NC = matrix[0].length;
        
        int left = 0, right = NR * NC - 1;
        while(left != right){
            int mid = left + (right - left) / 2 + 1;
            int val = matrix[mid / NC][mid % NC];
            
            //if(cur == target) return true;
            if(target < val) right = mid - 1;
            else left = mid;
        }
        
        return matrix[(left) / NC][(left) % NC] == target;
    }
}