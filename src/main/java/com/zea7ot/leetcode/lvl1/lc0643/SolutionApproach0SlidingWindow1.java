/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/maximum-average-subarray-ii/
 */
package com.zea7ot.leetcode.lvl1.lc0643;

public class SolutionApproach0SlidingWindow1 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        
        long max = sum;
        
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        
        return max / 1.0 / k;
    }
}