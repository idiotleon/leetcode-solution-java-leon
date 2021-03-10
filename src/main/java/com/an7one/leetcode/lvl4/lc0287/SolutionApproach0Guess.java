/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl4.lc0287;

public class SolutionApproach0Guess {
    public int findDuplicate(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = getCount(nums, mid);
            if(count > mid) hi = mid;
            else lo = mid + 1;
        }
        
        return lo;
    }
    
    private int getCount(int[] nums, int limit){
        int count = 0;
        for(int num : nums){
            if(num <= limit){
                ++count;
            }
        }
        return count;
    }
}