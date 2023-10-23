package com.idiotleon.leetcode.lvl4.lc0456;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/132-pattern/">LC0456</a>
 * <p>
 * Time Complexity:     O(N), one pass
 * Space Complexity:    O(N)
 * <p>
 * <a href="https://leetcode.com/problems/132-pattern/discuss/94089/Java-solutions-from-O(n3)-to-O(n)-for-%22132%22-pattern-(updated-with-one-pass-slution)">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack1 {
    public boolean find132pattern(int[] nums) {
        final int L = nums.length;

        int j = L, kVal = Integer.MIN_VALUE;

        for (int i = L - 1; i >= 0; i--) {
            if (nums[i] < kVal) {
                return true;
            }

            while (j < L && nums[i] > nums[j]) {
                kVal = nums[j++];
            }

            nums[--j] = nums[i];
        }

        return false;
    }
}