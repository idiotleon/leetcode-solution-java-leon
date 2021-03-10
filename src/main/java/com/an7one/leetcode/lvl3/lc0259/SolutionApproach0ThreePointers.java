/**
 * https://leetcode.com/problems/3sum-smaller/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0259;

import java.util.Arrays;

public class SolutionApproach0ThreePointers {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        Arrays.sort(nums);

        for (int idx = 0; idx < N - 2; ++idx) {
            int lo = idx + 1, hi = N - 1;
            while (lo < hi) {
                int sum = nums[idx] + nums[lo] + nums[hi];

                if (sum < target) {
                    ans += hi - lo;
                    ++lo;
                } else {
                    --hi;
                }
            }
        }

        return ans;
    }
}