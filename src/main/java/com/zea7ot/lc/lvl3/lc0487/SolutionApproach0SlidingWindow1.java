/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * `idxZero` keeps the index of the zero within the window [lo, hi].
 * this is a specific, to 1 flip only, approach
 * 
 * References:
 *  https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled
 */
package com.zea7ot.lc.lvl3.lc0487;

public class SolutionApproach0SlidingWindow1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int longest = 0;
        int idxZero = -1;
        int lo = 0, hi = 0;
        while(hi < N){
            if(nums[hi] == 0){
                lo = idxZero + 1;
                idxZero = hi;
            }
            
            longest = Math.max(longest, hi - lo + 1);
            
            ++hi;
        }
        
        return longest;
    }
}