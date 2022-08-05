package com.an7one.leetcode.lvl3.lc0377;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">LC0377</a>
 * <p>
 * TLEed
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach2DFS {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int ans = 0;
        for (int num : nums) {
            if (target >= num) {
                ans += combinationSum4(nums, target - num);
            }
        }
        return ans;
    }
}