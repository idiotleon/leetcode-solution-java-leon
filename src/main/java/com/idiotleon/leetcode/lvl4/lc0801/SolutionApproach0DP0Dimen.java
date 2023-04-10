/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-DP-O(N)-Solution/561174
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 */
package com.idiotleon.leetcode.lvl4.lc0801;

public class SolutionApproach0DP0Dimen {
    public int minSwap(int[] A, int[] B) {
        final int N = A.length;

        int prevSwap = 1;
        int prevNotSwap = 0;

        for (int i = 1; i < N; ++i) {
            int swap = N, notSwap = N;

            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap = prevSwap + 1;
                notSwap = prevNotSwap;
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap = Math.min(swap, prevNotSwap + 1);
                notSwap = Math.min(notSwap, prevSwap);
            }

            prevSwap = swap;
            prevNotSwap = notSwap;
        }

        return Math.min(prevSwap, prevNotSwap);
    }
}
