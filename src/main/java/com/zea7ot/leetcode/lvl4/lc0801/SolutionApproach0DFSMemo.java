/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/262241/Recursive-with-memoization-(beats-100.00-)%3A
 */
package com.zea7ot.leetcode.lvl4.lc0801;

public class SolutionApproach0DFSMemo {
    private static final int RANGE = (int) 2e3 + 1;
    private static final int SWAP = 1;
    private static final int NOT_SWAP = 0;

    public int minSwap(int[] A, int[] B) {
        final int N = A.length;
        Integer[][] dp = new Integer[N][2];

        return dfs(0, -1, -1, NOT_SWAP, A, B, dp);
    }

    private int dfs(int idx, int prevA, int prevB, int swapState, int[] A, int[] B, Integer[][] dp) {
        final int N = A.length;
        if (idx == N)
            return 0;
        if (dp[idx][swapState] != null)
            return dp[idx][swapState];

        int minSwaps = RANGE;

        // not going to swap
        if (A[idx] > prevA && B[idx] > prevB) {
            minSwaps = dfs(idx + 1, A[idx], B[idx], NOT_SWAP, A, B, dp);
        }

        // going to swap
        if (B[idx] > prevA && A[idx] > prevB) {
            // to perform swap here
            minSwaps = Math.min(minSwaps, dfs(idx + 1, B[idx], A[idx], SWAP, A, B, dp) + 1);
        }

        return dp[idx][swapState] = minSwaps;
    }
}
