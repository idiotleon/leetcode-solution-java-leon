package com.idiotleon.leetcode.lvl3.lc0378;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">LC0378</a>
 * <p>
 * Time Complexity:     O(`NC` * lg(MAX - MIN))
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378>LCDiscussion</a>a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) return -1;

        final int NR = matrix.length, NC = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[NR - 1][NC - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = getCount(matrix, mid);

            if (k >= count) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private int getCount(int[][] matrix, int target) {
        final int NR = matrix.length, NC = matrix[0].length;

        int count = 0;
        for (int row = 0, col = NC - 1; row < NR; row++) {
            while (col >= 0 && matrix[row][col] > target) {
                col--;
            }
            count += (col + 1);
        }

        return count;
    }
}