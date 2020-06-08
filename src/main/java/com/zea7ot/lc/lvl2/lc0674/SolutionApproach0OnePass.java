/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl2.lc0674;

public class SolutionApproach0OnePass {
    public int findLengthOfLCIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        int ans = 0, count = 0;
        final int N = nums.length;
        for(int i = 0; i < N; i++){
            if(i == 0 || nums[i - 1] < nums[i]) {
                ans = Math.max(ans, ++count);
            } else count = 1;
        }
        return ans;
    }
}