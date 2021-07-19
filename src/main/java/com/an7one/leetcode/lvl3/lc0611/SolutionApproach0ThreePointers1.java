package com.an7one.leetcode.lvl3.lc0611;

import com.an7one.util.Constant;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number/
 * <p>
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/valid-triangle-number/discuss/104169/Java-Solution-3-pointers
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ThreePointers1 {
    public int triangleNumber(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 3)
            return 0;

        final int N = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int idx = 2; idx < N; ++idx) {
            int lo = 0, hi = idx - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[idx]) {
                    ans += hi - lo;
                    --hi;
                } else
                    ++lo;
            }
        }

        return ans;
    }
}