package com.idiotleon.leetcode.lvl3.lc0487;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">LC0487</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * `idxZero` keeps the index of the zero within the window [lo, hi].
 * this is a specific, to 1 flip only, approach
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0SlidingWindow1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int N = nums.length;
        int longest = 0;
        int idxZero = -1;
        int lo = 0, hi = 0;
        while (hi < N) {
            if (nums[hi] == 0) {
                lo = idxZero + 1;
                idxZero = hi;
            }

            final int len = hi - lo + 1;
            longest = Math.max(longest, len);

            ++hi;
        }

        return longest;
    }
}