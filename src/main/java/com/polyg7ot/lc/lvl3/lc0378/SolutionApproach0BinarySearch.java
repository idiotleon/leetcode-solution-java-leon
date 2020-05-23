/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Time Complexity: O(NC * lg(MAX - MIN))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
 */
package com.polyg7ot.lc.lvl3.lc0378;

public class SolutionApproach0BinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        int left = matrix[0][0], right = matrix[NR - 1][NC - 1];
        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if(k > count) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
    
    private int getCount(int[][] matrix, int target){
        final int NR = matrix.length, NC = matrix[0].length;
        
        int count = 0;
        for(int row = 0, col = NC - 1; row < NR; row++){
            while(col >= 0 && matrix[row][col] > target) col--;
            count += (col + 1);
        }
        
        return count;
    }
}