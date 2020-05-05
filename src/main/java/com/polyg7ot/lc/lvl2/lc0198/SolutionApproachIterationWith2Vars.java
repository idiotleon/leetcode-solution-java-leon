/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Iterative + 2 variables (bottom-up)
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.polyg7ot.lc.lvl2.lc0198;

public class SolutionApproachIterationWith2Vars {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        
        for(int num : nums){
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        
        return prev1;
    }

    public int rob2(int[] nums) {
        int prevNo = 0, prevYes = 0;
        for(int num : nums){
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}