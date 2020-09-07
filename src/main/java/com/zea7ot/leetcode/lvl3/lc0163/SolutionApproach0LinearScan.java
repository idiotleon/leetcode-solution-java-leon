/**
 * https://leetcode.com/problems/missing-ranges/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0163;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0LinearScan {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0) {
            ans.add(getRange(lower, upper));
            return ans;
        }

        final int N = nums.length;

        // 1st step: to find the range between "lower" and the first element in the
        // array
        if (nums[0] > lower)
            ans.add(getRange(lower, nums[0] - 1));

        // 2nd step: to find ranges between adjacent elements in the array
        for (int i = 0; i < N - 1; ++i) {
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
                ans.add(getRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // 3rd step: to find the range between "upper" and last element in the array
        if (nums[N - 1] < upper)
            ans.add(getRange(nums[N - 1] + 1, upper));

        return ans;
    }

    private String getRange(final int LO, final int HI) {
        return (LO == HI) ? String.valueOf(LO) : String.format("%d->%d", LO, HI);
    }
}