/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0930;

public class SolutionApproachPreSum {
    public int numSubarraysWithSum(int[] nums, int S) {
        final int L = nums.length;
        int preSum = 0, ans = 0;
        int[] count = new int[L + 1];
        
        count[0] = 1;
        
        for(int num : nums){
            preSum += num;
            if(preSum >= S){
                ans += count[preSum - S];
            }
            ++count[preSum];
        }
        
        return ans;
    }
}