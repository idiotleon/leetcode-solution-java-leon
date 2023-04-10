/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107318/C%2B%2B-DP-with-explanation-O(n2)
 */
package com.idiotleon.leetcode.lvl4.lc0673;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
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

        for (int hi = 0; hi < N; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                if (nums[lo] < nums[hi]) {
                    if (lens[hi] == lens[lo] + 1) {
                        counts[hi] += counts[lo];
                    } else if (lens[hi] < lens[lo] + 1) {
                        lens[hi] = lens[lo] + 1;
                        counts[hi] = counts[lo];
                    }
                }
            }

            longest = Math.max(longest, lens[hi]);
        }

        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (lens[i] == longest) {
                count += counts[i];
            }
        }
        return count;
    }
}