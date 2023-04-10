package com.idiotleon.leetcode.lvl3.lc0377;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iv/
 * <p>
 * Time Complexity:     O(`target` * `N`)
 * Space Complexity:    O(`target`)
 * <p>
 * References:
 * https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation/256496
 * https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation/89652
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSMemo1 {
    public int combinationSum4(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0 || target <= 0)
            return 0;

        return dfs(nums, target, new HashMap<>());
    }

    private int dfs(final int[] nums, final int target, final Map<Integer, Integer> memo) {
        final int N = nums.length;

        if (target < 0)
            return 0;

        if (target == 0)
            return 1;

        if (memo.containsKey(target))
            return memo.get(target);

        int count = 0;
        for (int num : nums) {
            count += dfs(nums, target - num, memo);
        }

        memo.put(target, count);
        return count;
    }
}