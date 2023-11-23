package com.idiotleon.leetcode.lvl3.lc0494;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/target-sum/">LC0494</a>
 * <p>
 * Time Complexity:     O(2 ^ N)
 * Space Complexity:    O(N ^ 2)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSNaively1 {
    private int count;

    public int findTargetSumWays(final int[] nums, final int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        this.count = 0;
        dfs(0, 0, nums, target);
        return count;
    }

    private void dfs(final int idx, final int sum, final int[] nums, final int target) {
        final int N = nums.length;
        if (idx == N) {
            if (sum == target) {
                ++count;
            }
        } else {
            dfs(idx + 1, sum + nums[idx], nums, target);
            dfs(idx + 1, sum - nums[idx], nums, target);
        }
    }
}