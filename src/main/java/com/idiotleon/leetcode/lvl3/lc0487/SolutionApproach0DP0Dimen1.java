package com.idiotleon.leetcode.lvl3.lc0487;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">LC0487</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP0Dimen1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flipped = 0, notFlipped = 0;
        int longest = 0;
        for (int num : nums) {
            if (num == 0) {
                flipped = notFlipped + 1;
                notFlipped = 0;
            } else {
                flipped = flipped + 1;
                notFlipped = notFlipped + 1;
            }

            longest = Math.max(longest, Math.max(flipped, notFlipped));
        }

        return longest;
    }
}