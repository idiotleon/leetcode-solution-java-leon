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
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/152332/Java-clean-DP-O(n2)-time-O(n2)-space
 */
package com.an7one.leetcode.lvl3.lc0873;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DP2Dimen1 {
    public int lenLongestFibSubseq(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][N];
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            idxMap.put(nums[i], i);
            for (int j = i; j < N; j++)
                dp[i][j] = 2;
        }

        for (int hi = 2; hi < N; hi++) {
            for (int lo = hi - 1; lo > 0; lo--) {
                int prev = nums[hi] - nums[lo];
                // pruning here
                if (prev >= nums[lo])
                    break;
                if (!idxMap.containsKey(prev))
                    continue;
                dp[lo][hi] = dp[idxMap.get(prev)][lo] + 1;
            }
        }

        int max = 0;
        for (int hi = 2; hi < N; hi++) {
            for (int lo = 1; lo < N - 1; lo++) {
                if (dp[lo][hi] > 2) {
                    max = Math.max(max, dp[lo][hi]);
                }
            }
        }
        return max;
    }
}