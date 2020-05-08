/**
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl3.lc0213;

public class SolutionApproachDP1 {
    public int rob(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int L = nums.length;
        if(L == 1) return nums[0];
        
        // to rob houses from 1 to (L - 2)
        int lastPrev = 0, sum = 0, ans = 0;
        for(int i = 0; i < L - 1; i++){
            int prev = sum;
            sum = Math.max(sum, lastPrev + nums[i]);
            lastPrev = prev;
        }
        ans = sum;
        
        // to rob houses from 1 to (L - 1)
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