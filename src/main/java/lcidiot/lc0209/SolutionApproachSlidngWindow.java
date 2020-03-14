/**
 * LC0209: Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the
 * subarray [4,3] has the minimal length under the problem constraint. Follow
 * up: If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n).
 */
package main.java.lcidiot.lc0209;

import java.lang.Math;

class SolutionApproachSlidngWindow {
    public int minSubArrayLen(int s, int[] nums) {
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
