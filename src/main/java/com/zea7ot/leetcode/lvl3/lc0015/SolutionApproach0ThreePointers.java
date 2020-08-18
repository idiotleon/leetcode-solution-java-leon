/**
 * https://leetcode.com/problems/3sum
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0ThreePointers {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        Arrays.sort(nums);
        for (int idx = 0; idx < N - 2; ++idx) {
            if (idx > 0 && nums[idx] == nums[idx - 1])
                continue;

            int lo = idx + 1, hi = N - 1;
            int target = -nums[idx];

            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    ans.add(Arrays.asList(nums[idx], nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                    while (lo < hi && nums[lo - 1] == nums[lo])
                        ++lo;
                    while (lo < hi && nums[hi] == nums[hi + 1])
                        --hi;
                } else if (nums[lo] + nums[hi] > target)
                    --hi;
                else
                    ++lo;
            }
        }

        return ans;
    }
}