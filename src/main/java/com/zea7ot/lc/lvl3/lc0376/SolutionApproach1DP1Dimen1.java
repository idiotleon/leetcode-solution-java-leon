/**
 * https://leetcode.com/problems/wiggle-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=1306
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_299
 *  https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version
 */
package com.zea7ot.lc.lvl3.lc0376;

import java.util.Arrays;

public class SolutionApproach1DP1Dimen1 {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int[][] dp = new int[N][2];
        Arrays.fill(dp[0], 1);
        
        for(int i = 1; i < N; i++){
            if(nums[i - 1] < nums[i]){
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            }else if(nums[i - 1] > nums[i]){
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            }else{
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        
        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }
}