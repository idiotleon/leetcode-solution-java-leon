/**
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0016;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int ans = nums[0] + nums[1] + nums[N - 1];
        Arrays.sort(nums);
        for (int idx = 0; idx < N - 2; ++idx) {
            int lo = idx + 1, hi = N - 1;
            while (lo < hi) {
                int sum = nums[idx] + nums[lo] + nums[hi];
                if (sum > target)
                    --hi;
                else
                    ++lo;

                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
            }
        }

        return ans;
    }
}