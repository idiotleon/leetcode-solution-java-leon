package com.zea7ot.algorithm.summary.search.binary_search;

public class KthSmallest {
    /**
     * Time Complexity: O(NC * lg(MAX - MIN))
     * Space Complexity: O(1)
     * 
     * The binary search solution is much more efficient compared to those derived in previous sections, 
     * which only uses constant space and the time complexity is almost linear for any practical integer matrices,
     * for which MIN and MAX are within the 32-bit integer range.
     * 
     * @param matrix
     * @param k
     * @return
     * 
     * References:
     *  m/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-"reducible"-to-LeetCode-378
     */
    public int KthSmallestWithBinarySearch(int[][] matrix, int k){
        final int NR = matrix.length, NC = matrix[0].length;

        int left = matrix[0][0];                // minimum element in the matrix
        int right = matrix[NR - 1][NC - 1];     // maximum element in the matrix

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