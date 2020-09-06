/**
 * https://leetcode.com/problems/image-overlap/
 * 
 * Time Complexity:     O((NR * NC) ^ 2) ~ O(N ^ 4)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/image-overlap/discuss/161851/Java-most-intuitive-solution
 */
package com.zea7ot.leetcode.lvl3.lc0835;

public class SolutionApproach1LinearScan {
    public int largestOverlap(int[][] A, int[][] B) {
        final int N = A.length;
        int largest = 0;
        for (int rowOffset = -N; rowOffset < N; ++rowOffset) {
            for (int colOffset = -N; colOffset < N; ++colOffset) {
                largest = Math.max(largest, getOverlap(rowOffset, colOffset, A, B));
            }
        }

        return largest;
    }

    private int getOverlap(int rowOffset, int colOffset, int[][] A, int[][] B) {
        final int N = A.length;
        int overlap = 0;

        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                int r = row + rowOffset;
                int c = col + colOffset;
                if (r < 0 || r >= N || c < 0 || c >= N)
                    continue;

                if (A[row][col] == 1 && B[r][c] == 1)
                    ++overlap;
            }
        }

        return overlap;
    }
}
