package com.an7one.leetcode.lvl3.lc0376;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/wiggle-subsequence/">LC0376</a>
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version/89522">Reference</a>
 * <a href="https://youtu.be/FLbqgyJ-70I?t=1306">Youtube</a>
 * <a href="https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_299">Google Doc</a>
 * <a href="https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version">Leetcode</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP0Dimen {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int up = 1, down = 1;

        for (int i = 1; i < N; ++i) {
            if (nums[i - 1] > nums[i])
                down = up + 1;
            else if (nums[i - 1] < nums[i])
                up = down + 1;
        }

        return Math.max(down, up);
    }
}