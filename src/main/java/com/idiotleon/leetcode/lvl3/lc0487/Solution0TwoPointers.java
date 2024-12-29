package com.idiotleon.leetcode.lvl3.lc0487;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">LCDiscussion</a>
 * <p>
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream?
 * In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
 * Could you solve it efficiently?
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0TwoPointers {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int N = nums.length;
        int longest = 0;
        int zeroLeft = 0, zeroRight = 0;
        for (int num : nums) {
            zeroRight++;
            if (num == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }

            longest = Math.max(longest, zeroLeft + zeroRight);
        }

        return longest;
    }
}