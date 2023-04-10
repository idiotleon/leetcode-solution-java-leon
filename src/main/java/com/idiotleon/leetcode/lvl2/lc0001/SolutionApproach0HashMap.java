package com.idiotleon.leetcode.lvl2.lc0001;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * https://leetcode.com/problems/two-sum/discuss/715951/Rust%3A-HashMap-solutio
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HashMap {
    public int[] twoSum(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        Map<Integer, Integer> sumToIdx = new HashMap<>();
        final int N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (sumToIdx.containsKey(target - nums[i]))
                return new int[]{i, sumToIdx.get(target - nums[i])};

            sumToIdx.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}