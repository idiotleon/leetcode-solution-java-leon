/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Time Complexity: O(NR * NC)
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
 */
package com.idiotleon.leetcode.lvl3.lc0378;

public class SolutionApproach1ZigZagSearch {
    public int kthSmallest(int[][] matrix, int k) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0)
            return -1;

        final int NR = matrix.length, NC = matrix[0].length;

        // to start from the upper-right corner
        int row = 0, col = NC - 1;
        while (true) {
            int countLessAndEqual = 0, countLessThan = 0;
            for (int i = 0, j = NC - 1, p = NC - 1; i < NR; i++) {
                while (j >= 0 && matrix[i][j] > matrix[row][col])
                    j--; // pointer j to count "countLessAndEqual"
                countLessAndEqual += (j + 1);

                while (p >= 0 && matrix[i][p] >= matrix[row][col])
                    p--; // pointer p to count "countLessThan"
                countLessThan += (p + 1);
            }

            if (countLessAndEqual < k)
                row++; // candidate is too small, so should increase it
            else if (countLessThan >= k)
                col--; // candidate is too large, so should decrease it
            else
                return matrix[row][col]; // candidate is equal to the kth smallest element
        }
    }
}