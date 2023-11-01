/**
 * https://leetcode.com/problems/4sum/
 * <p>
 * how about k sum?
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * References:
 * https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
 */
package com.idiotleon.leetcode.lvl3.lc0015.followup;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> threeSum(final int[] nums, final int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 3, target);
    }

    private List<List<Integer>> kSum(final int[] nums, final int start, final int k, final int target) {
        final int len = nums.length;
        final List<List<Integer>> res = new ArrayList<>();
        if (k == 2) { // two pointers from lo and hi
            int lo = start, hi = len - 1;
            while (lo < hi) {
                final int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    final List<Integer> path = new ArrayList<>();
                    path.add(nums[lo]);
                    path.add(nums[hi]);
                    res.add(path);
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        ++lo;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        --hi;
                    }
                    ++lo;
                    --hi;
                } else if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        } else for (int i = start; i < len - (k - 1); ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            final List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
            for (List<Integer> t : temp) {
                t.add(0, nums[i]);
            }
            res.addAll(temp);
        }

        return res;
    }
}