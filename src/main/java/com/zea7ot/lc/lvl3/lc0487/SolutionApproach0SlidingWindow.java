/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * this is a general approach, with at most `k` flips.
 * this approach cannot be applied to STREAMS as inputs.
 * 
 * References:
 *  https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled
 */
package com.zea7ot.lc.lvl3.lc0487;

public class SolutionApproach0SlidingWindow {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int longest = 0, zero = 0;
        // to flip at most k times
        int k = 1;
        
        int lo = 0, hi = 0;
        while(hi < N){
            if(nums[hi] == 0) ++zero;
            while(zero > k)
                if(nums[lo++] == 0) --zero;
            
            longest = Math.max(longest, hi - lo + 1);
            
            ++hi;
        }
        
        return longest;
    }
}