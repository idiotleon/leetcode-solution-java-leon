/**
 * https://leetcode.com/problems/single-number-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
 */
package com.zea7ot.lc.lvl3.lc0260;

public class SolutionApproach0BitManipulation {
    public int[] singleNumber(int[] nums) {
        // 1st pass
        int diff = 0;
        for(int num : nums) diff ^= num;
        
        // to get its last set bit
        diff &= -diff;
        
        // 2nd pass
        int[] ans = {0, 0};
        for(int num : nums){
            if((num & diff) == 0){
                ans[0] ^= num;
            }else ans[1] ^= num;
        }
        
        return ans;
    }
}