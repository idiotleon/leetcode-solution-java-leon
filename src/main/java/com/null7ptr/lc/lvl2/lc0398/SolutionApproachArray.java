/**
 * https://leetcode.com/problems/random-pick-index/
 * 
 * Reservoir Sampling
 */
package com.null7ptr.lc.lvl2.lc0398;

import java.util.Random;

public class SolutionApproachArray {
    private int[] nums;
    private Random random;

    public SolutionApproachArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != target) continue;
            
            if(random.nextInt(++count) == 0){
                result = i;
            }
        }
        
        return result;
    }
}