/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(1)
 * 
 * To find the next best/farthest jump in the range this jump can reach.
 * If any position cannot be reached, to return -1.
 * 
 * https://youtu.be/G88X89Eo2C0?t=696
 */
package com.zea7ot.lc.lvl4.lc0045;

public class SolutionApproachGreedy {
    public int jump(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int[] maxRange = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            maxRange[i] = i + nums[i];
        }
        
        int steps = 0;
        // the previous max jump
        int left = 0;
        // the max it can jump
        int end = 0;
        
        for(int i = 0; i < nums.length; ++i){
            if(i > end) return -1;
            if(i > left) { // this means, a jump is required
                ++steps;
                left = end;
            }
            
            end = Math.max(end, maxRange[i]);
        }
        
        return steps;
    }
}