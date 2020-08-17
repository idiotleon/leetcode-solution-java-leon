/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/633058/Java-or-C%2B%2B-or-Python3-or-With-detailed-explanation-or-O(N)-time-or-O(1)
 *  https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
 */
package com.zea7ot.leetcode.lvl4.lc0918;

public class SolutionApproach0KadanesAlgorithm {
    public int maxSubarraySumCircular(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int sum = nums[0];
        int localMax = nums[0];
        int globalMax = nums[0];
        int localMin = nums[0];
        int globalMin = nums[0];
        
        for(int i = 1; i < N; ++i){
            int num = nums[i];
            localMax = Math.max(num, localMax + num);
            globalMax = Math.max(globalMax, localMax);
            
            localMin = Math.min(num, localMin + num);
            globalMin = Math.min(globalMin, localMin);
            
            sum += num;
        }
        
        if(sum == globalMin) return globalMax;
        return Math.max(globalMax, sum - globalMin);
    }
}