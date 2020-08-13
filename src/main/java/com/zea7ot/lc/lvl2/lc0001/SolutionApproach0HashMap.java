/**
 * @author: Leon
 * https://leetcode.com/problems/two-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl2.lc0001;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public int[] twoSum(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        final int N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (idxMap.containsKey(target - nums[i]))
                return new int[] { i, idxMap.get(target - nums[i]) };

            idxMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}