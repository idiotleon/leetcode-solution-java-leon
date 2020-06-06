/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.zea7ot.lc.lvl2.lc0198;

public class SolutionApproach0DP2 {
    public int rob(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        
        for(int num : nums){
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        
        return prev1;
    }
}