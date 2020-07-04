/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i][j] represents the longest fibonacci sequence ending with `nums[i]` and `nums[j]`
 * dp[i][j] = (dp[j - i][i] + 1) or 2
 * 
 * References:
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/152332/Java-clean-DP-O(n2)-time-O(n2)-space/377212
 */
package com.zea7ot.lc.lvl3.lc0873;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DP2Dimen2 {
    public int lenLongestFibSubseq(int[] nums) {
        final int N = nums.length;
        int max = 0;
        
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) idxMap.put(nums[i], i);
        int[][] dp = new int[N][N];
        for(int hi = N - 1; hi > 0; hi--){
            for(int lo = hi - 1; lo >= 0; lo--){
                if(dp[lo][hi] == 0) dp[lo][hi] = 2;
                
                int next = nums[lo] + nums[hi];
                if(idxMap.containsKey(next)){
                    dp[lo][hi] = dp[hi][idxMap.get(next)] + 1;
                    max = Math.max(max, dp[lo][hi]);
                }
            }
        }
        
        return max >= 3 ? max : 0;
    }
}