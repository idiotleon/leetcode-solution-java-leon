/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Time Complexity: O(N lg(max - min))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85177/Java-1ms-nlog(max-min)-solution
 *  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 */
package com.idiotleon.leetcode.lvl3.lc0378;

public class SolutionApproach0BinarySearch1 {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;

        final int NR = matrix.length, NC = matrix[0].length;
        if (k > NR * NC)
            return -1;

        int left = matrix[0][0], right = matrix[NR - 1][NC - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, j = NC - 1;
            for (int i = 0; i < NR; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += j + 1;
            }

            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}