/**
 * LC240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * Consider the following matrix:
 * [
 *  [1,   4,  7, 11, 15],
 *  [2,   5,  8, 12, 19],
 *  [3,   6,  9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */

package com.zea7ot.lc.lvl4.lc0240;

import java.lang.Math;

public class SolutionApproachBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);

            if (verticalFound || horizontalFound)
                return true;
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (vertical) {
                if (matrix[start][mid] < target){
                    lo = mid + 1;
                }
                else if (matrix[start][mid] > target){
                    hi = mid - 1;
                }
                else return true;
            } else {
                if (matrix[mid][start] < target){
                    lo = mid + 1;
                }
                else if (matrix[mid][start] > target){
                    hi = mid - 1;
                }
                else return true;
            }
        }

        return false;
    }
}