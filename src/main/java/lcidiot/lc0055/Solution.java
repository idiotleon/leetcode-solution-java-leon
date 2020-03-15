/**
 * https://leetcode.com/problems/jump-game/
 * 
 * Greedy
 */

package main.java.lcidiot.lc0055;

class Solution{
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        
        return true;
    }
}