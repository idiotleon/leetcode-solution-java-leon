/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl2.lc0209;

public class SolutionApproach0SlidngWindow1 {
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0, count = 0, ans = Integer.MAX_VALUE;
        for (int j = 0, i = 0; j < nums.length; j++) {
            sum += nums[j];
            count++;
            if (sum >= s) {
                while (i < j && sum - nums[i] >= s) {
                    sum -= nums[i];
                    count--;
                    i++;
                }
                ans = Math.min(ans, count);
            }
        }

        if (sum < s)
            return 0;

        return ans;
    }
}
