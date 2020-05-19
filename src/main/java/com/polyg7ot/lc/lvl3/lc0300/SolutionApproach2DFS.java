/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 *  O(N), the call stack
 * 
 * References:
 *  https://www.youtube.com/watch?v=CE2b_-XfVDk
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java
 */
package com.polyg7ot.lc.lvl3.lc0300;

public class SolutionApproach2DFS {
    public int lengthOfLIS(int[] nums) {
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