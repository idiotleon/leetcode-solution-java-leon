/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl4.lc0540;

public class SolutionApproach2OnePass {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}