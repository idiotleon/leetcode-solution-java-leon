/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC%2B%2B-Simple-dp-solution-with-explanation
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC++-Simple-dp-solution-with-explanation/177757
 */
package com.zea7ot.leetcode.lvl4.lc0673;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen1 {
    public int findNumberOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] lens = new int[N];
        Arrays.fill(lens, 1);
        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        int longest = 0;
        int count = 0;

        for (int hi = 0; hi < N; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                if (nums[hi] > nums[lo]) {
                    if (lens[hi] == lens[lo] + 1)
                        counts[hi] += counts[lo];
                    if (lens[hi] < lens[lo] + 1) {
                        lens[hi] = lens[lo] + 1;
                        counts[hi] = counts[lo];
                    }
                }
            }

            if (longest == lens[hi]) {
                count += counts[hi];
            }
            if (longest < lens[hi]) {
                longest = lens[hi];
                count = counts[hi];
            }
        }

        return count;
    }
}