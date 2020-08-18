/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Follow up:
 *  What if the input numbers come in one by one as an infinite stream? 
 *  In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. 
 *  Could you solve it efficiently?
 * 
 * References:
 *  https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled
 */
package com.zea7ot.leetcode.lvl3.lc0487.followup;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0SlidingWindow {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int longest = 0;
        // to flip at most k times
        int k = 1;
        Deque<Integer> idxZeros = new ArrayDeque<Integer>();
        int lo = 0, hi = 0;
        while(hi < N){
            if(nums[hi] == 0) idxZeros.offer(hi);
            if(idxZeros.size() > k)
                lo = idxZeros.poll() + 1;
            longest = Math.max(longest, hi - lo + 1);
            
            ++hi;
        }
        
        return longest;
    }
}