/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-O(1)-Space
 */
package com.idiotleon.leetcode.lvl4.lc1248;

public class SolutionApproach0SlidingWindow {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k){
        final int N = nums.length;
        int lo = 0, hi = 0;
        int longest = 0;
        
        while(hi < N){
            k -= nums[hi] % 2;
            while(k < 0){
                k += nums[lo] % 2;
                ++lo;
            }
            
            longest += hi - lo + 1;
            ++hi;
        }
        
        return longest;
    }
}