/**
 * https://leetcode.com/problems/make-array-strictly-increasing/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(`N2`) + O(`N1` ^ 2)
 * 
 * `dp[lo][hi]`, the minimal value for the range [lo, hi - 1], both ends inclusive
 * 
 * References:
 *  https://leetcode.com/problems/make-array-strictly-increasing/discuss/377680/Simple-Java-DP-Solution-%2B-TreeSet-with-Explanation-beats-100
 *  https://leetcode.com/problems/make-array-strictly-increasing/discuss/377531/O(n2-log(n))-solutionStarting-from-brute-force-improve-by-memoization
 */
package com.an7one.leetcode.lvl4.lc1187;

import java.util.Arrays;
import java.util.TreeSet;

public class SolutionApproach0DP1DimenWithTreeSet {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // sanity check
        if (arr1 == null || arr1.length == 0)
            return -1;
        final int N1 = arr1.length;
        if (arr1.length == 1)
            return 0;

        TreeSet<Integer> treeSet = new TreeSet<>();
        if (arr2 != null) {
            for (int num : arr2) {
                treeSet.add(num);
            }
        }

        int[][] dp = new int[N1 + 1][N1 + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = Integer.MIN_VALUE;

        for (int hi = 1; hi <= N1; ++hi) {
            for (int lo = 0; lo <= hi; ++lo) {
                if (arr1[hi - 1] > dp[lo][hi - 1]) {
                    dp[lo][hi] = arr1[hi - 1];
                }

                if (lo > 0 && treeSet.higher(dp[lo - 1][hi - 1]) != null) {
                    dp[lo][hi] = Math.min(dp[lo][hi], treeSet.higher(dp[lo - 1][hi - 1]));
                }

                if (hi == N1 && dp[lo][hi] != Integer.MAX_VALUE)
                    return lo;
            }
        }

        return -1;
    }
}
