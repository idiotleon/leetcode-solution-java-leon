/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-arithmetic-sequence/discuss/274701/Java-DP-O(n2)-solution-with-explanation
 *  https://leetcode.com/problems/longest-arithmetic-sequence/discuss/274611/JavaC%2B%2BPython-DP
 */
package com.idiotleon.leetcode.lvl4.lc1027;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DP2 {
    @SuppressWarnings("unchecked")
    public int longestArithSeqLength(int[] nums) {
        final int N = nums.length;
        int longest = 2;

        Map<Integer, Integer>[] dp = new HashMap[N];
        for (int i = 0; i < N; ++i) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; ++j) {
                int variance = nums[i] - nums[j];
                dp[i].put(variance, dp[j].getOrDefault(variance, 1) + 1);
                longest = Math.max(longest, dp[i].get(variance));
            }
        }

        return longest;
    }
}