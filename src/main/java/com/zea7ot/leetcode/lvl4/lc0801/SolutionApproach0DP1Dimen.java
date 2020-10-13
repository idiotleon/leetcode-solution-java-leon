/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-DP-O(N)-Solution/561174
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0801;

public class SolutionApproach0DP1Dimen {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N];
        swap[0] = 1;
        int[] notSwap = new int[N];
        // can be omitted
        // notSwap[0] = 0;

        for (int i = 1; i < N; i++) {
            notSwap[i] = swap[i] = N;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                notSwap[i] = notSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
            }
        }

        return Math.min(swap[N - 1], notSwap[N - 1]);
    }
}