/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0487;

public class SolutionApproach0DP {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flip = 0, unflip = 0, longest = 0;
        for(int num : nums){
            flip = num == 1 ? flip + 1 : unflip + 1;
            unflip = num == 1 ? unflip + 1 : 0;
            longest = Math.max(longest, Math.max(flip, unflip));
        }
        
        return longest;
    }
}