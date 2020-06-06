/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 *  https://youtu.be/7DKFpWnaxLI
 */
package com.zea7ot.lc.lvl3.lc0300;

public class SolutionApproach1DFSMemo {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int[] memo = new int[N];
        // this corresponds to line 46
        // Arrays.fill(memo, 1);
        int ans = 0;
        for(int i = 0; i < N; ++i){
            ans = Math.max(ans, dfs(nums, i, memo));
        }
        
        return ans;
    }
    
    /**
     * to return the length of LIS ending with nums[idx]
     */
    private int dfs(final int[] nums, int idx, final int[] memo){
        if(idx == 0) return 1;
        // this corresponds to line 31
        // if(memo[idx] > 1) return memo[idx];
        if(memo[idx] > 0) return memo[idx];
        
        int res = 1;
        for(int i = 0; i < idx; i++){
            if(nums[idx] > nums[i]){
                res = Math.max(res, dfs(nums, i, memo) + 1);
            }
        }
        
        memo[idx] = res;
        return res;
    }
}