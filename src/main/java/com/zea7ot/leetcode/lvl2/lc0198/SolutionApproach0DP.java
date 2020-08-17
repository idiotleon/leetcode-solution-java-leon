/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.zea7ot.leetcode.lvl2.lc0198;

public class SolutionApproach0DP {
    public int rob(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int prevNo = 0, prevYes = 0;
        
        for(int num : nums){
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}