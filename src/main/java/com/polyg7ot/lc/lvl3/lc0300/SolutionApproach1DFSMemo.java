/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 *  https://youtu.be/7DKFpWnaxLI
 * 
 * Similar Problems
 *  2   0674    https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *  3   1048    https://leetcode.com/problems/longest-string-chain/
 *  4   0128    https://leetcode.com/problems/longest-consecutive-sequence/
 *  4   0368    https://leetcode.com/problems/largest-divisible-subset/
 *  4   0646    https://leetcode.com/problems/maximum-length-of-pair-chain/
 *  4   0673    https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *  4   0740    https://leetcode.com/problems/delete-and-earn/
 *  5   0354    https://leetcode.com/problems/russian-doll-envelopes/
 */
package com.polyg7ot.lc.lvl3.lc0300;

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