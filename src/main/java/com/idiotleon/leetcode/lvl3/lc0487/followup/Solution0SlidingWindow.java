package com.idiotleon.leetcode.lvl3.lc0487.followup;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">LC0487</a>
 * <p>
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream?
 * In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
 * Could you solve it efficiently?
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0SlidingWindow {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int N = nums.length;
        int longest = 0;
        // to flip at most k times
        int k = 1;
        final Deque<Integer> idxZeros = new ArrayDeque<>();
        int lo = 0, hi = 0;
        while (hi < N) {
            if (nums[hi] == 0) {
                idxZeros.addLast(hi);
            }

            if (idxZeros.size() > k) {
                lo = idxZeros.removeFirst() + 1;
            }

            final int len = hi - lo + 1;
            longest = Math.max(longest, len);

            ++hi;
        }

        return longest;
    }
}