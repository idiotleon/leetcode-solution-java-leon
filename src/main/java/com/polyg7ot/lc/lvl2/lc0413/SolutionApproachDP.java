/**
 * https://leetcode.com/problems/arithmetic-slices/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl2.lc0413;

public class SolutionApproachDP {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int count = 0, total = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                count += 1;
                total += count;
            }else{
                count = 0;
            }
        }
        
        return total;
    }
}