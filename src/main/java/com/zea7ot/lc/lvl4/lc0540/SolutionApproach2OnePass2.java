/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl4.lc0540;

public class SolutionApproach2OnePass2 {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                ans += nums[i];
            }else{
                ans -= nums[i];
            }
        }
        
        return Math.abs(ans);
    }
}