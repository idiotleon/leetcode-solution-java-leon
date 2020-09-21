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

        int maxLen = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lens[i] == lens[j] + 1)
                        counts[i] += counts[j];
                    if (lens[i] < lens[j] + 1) {
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }

            if (maxLen == lens[i])
                ans += counts[i];
            if (maxLen < lens[i]) {
                maxLen = lens[i];
                ans = counts[i];
            }
        }

        return ans;
    }
}