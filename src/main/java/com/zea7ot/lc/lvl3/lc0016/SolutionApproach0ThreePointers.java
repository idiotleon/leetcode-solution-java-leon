/**
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0016;

import java.util.Arrays;

public class SolutionApproach0ThreePointers {
    public int threeSumClosest(int[] nums, int target) {
        // sanity checkhree
        if (nums == null || nums.length < 3)
            return 0;

        final int N = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[N - 1];
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