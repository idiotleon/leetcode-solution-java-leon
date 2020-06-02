/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 *  O(N), the call stack
 * 
 * References:
 *  https://www.youtube.com/watch?v=CE2b_-XfVDk
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java
 *  https://www.youtube.com/watch?v=7DKFpWnaxLI&list=PLLuMmzMTgVK7vEbeHBDD42pqqG36jhuOr&index=94
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

public class SolutionApproach2DFS {
    public int lengthOfLIS(int[] nums) {
        // santiy check
        if(nums == null || nums.length == 0) return 0;
        
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int len = lengthOfLIS(nums, i + 1, nums[i]);
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen + 1;
    }
    
    private int lengthOfLIS(int[] nums, int pos, int lastNum){
        if(pos == nums.length) return 0;
        
        int t1 = 0;
        if(nums[pos] > lastNum){
            t1 = 1 + lengthOfLIS(nums, pos + 1, nums[pos]);
        }
        
        int t2 = lengthOfLIS(nums, pos + 1, lastNum);
        return Math.max(t1, t2);
    }
}