package com.zea7ot.lc.lvl2.lc0384;

public class SolutionApproach0FisherYatesShuffle {
    private int[] nums;

    public SolutionApproach0FisherYatesShuffle(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int random = (int)(Math.random() * (i + 1));
            rand[i] = rand[random];
            rand[random] = nums[i];
        }
        
        return rand;
    }
}