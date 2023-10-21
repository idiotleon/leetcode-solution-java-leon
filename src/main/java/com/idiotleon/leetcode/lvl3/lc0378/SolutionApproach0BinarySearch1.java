package com.idiotleon.leetcode.lvl3.lc0378;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">LC0378</a>
 * <p>
 * Time Complexity: O(N * lg(max - min))
 * Space Complexity: O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85177/Java-1ms-nlog(max-min)-solution">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch1 {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        final int NR = matrix.length, NC = matrix[0].length;
        if (k > NR * NC) {
            return -1;
        }

        int lo = matrix[0][0], hi = matrix[NR - 1][NC - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = NC - 1;
            for (int[] row : matrix) {
                while (j >= 0 && row[j] > mid) {
                    --j;
                }
                count += j + 1;
            }

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}