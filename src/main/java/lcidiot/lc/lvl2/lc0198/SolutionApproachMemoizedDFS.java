/**
 * https://leetcode.com/problems/house-robber/
 * 
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package main.java.lcidiot.lc.lvl2.lc0198;

import java.util.Arrays;

class SolutionApproachMemorizedDFS {
    private int[] memo;
    
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }
    
    private int rob(int[] nums, int i){
        if(i < 0) return 0;
        
        if(memo[i] >= 0) return memo[i];
        
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}