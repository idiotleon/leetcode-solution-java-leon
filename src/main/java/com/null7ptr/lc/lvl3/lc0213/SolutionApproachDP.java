/**
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl3.lc0213;

public class SolutionApproachDP {
    public int rob(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int L = nums.length;
        if(L == 1) return nums[0];
        
        int lastPrev = 0, sum = 0, ans = 0;
        for(int i = 0; i < L - 1; i++){
            int prev = sum;
            sum = Math.max(sum, lastPrev + nums[i]);
            lastPrev = prev;
        }
        ans = sum;
        
        lastPrev = 0;
        sum = 0;
        for(int i = 1; i < L; i++){
            int prev = sum;
            sum = Math.max(sum, lastPrev + nums[i]);
            lastPrev = prev;
        }
        ans = Math.max(ans, sum);
        
        return ans;
    }
}