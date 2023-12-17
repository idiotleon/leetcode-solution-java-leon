package com.idiotleon.leetcode.lvl3.lc0477;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/total-hamming-distance/">LC0477</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/total-hamming-distance/discuss/96222/Java-Solution-with-Explanation/100721">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/total-hamming-distance/discuss/96222/Java-Solution-with-Explanation">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BitManipulation {
    public int totalHammingDistance(int[] nums) {
        final int N = nums.length;

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int ones = 0;
            for (int j = 0; j < N; ++j) {
                ones += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }

            ans += ones * (N - ones);
        }

        return ans;
    }
}