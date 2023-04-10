/**
 * https://leetcode.com/problems/shuffle-an-array/
 * 
 * References:
 *  https://leetcode.com/problems/shuffle-an-array/discuss/85958/First-Accepted-Solution-Java
 */
package com.idiotleon.leetcode.ood.lvl2.lc0384;

import java.util.Random;

public class SolutionApproach1Swap {
    private int[] nums;
    private Random random;

    public SolutionApproach1Swap(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] clone = nums.clone();
        for(int j = 1; j < clone.length; ++j){
            int i = random.nextInt(j + 1);
            swap(clone, i, j);
        }
        return clone;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}