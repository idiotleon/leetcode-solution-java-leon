/**
 * https://leetcode.com/problems/house-robber/
 * 
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.polyg7ot.lc.lvl2.lc0198;

public class SolutionApproachDP {
    public int rob(int[] nums) {
        int prevNo = 0, prevYes = 0;
        
        for(int num : nums){
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}