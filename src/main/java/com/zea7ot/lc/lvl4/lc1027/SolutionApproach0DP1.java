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
package com.zea7ot.lc.lvl4.lc1027;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DP1 {
    public int longestArithSeqLength(int[] nums) {
        final int N = nums.length;
        int longest = 2;

        List<Map<Integer, Integer>> dp = new ArrayList<>(N);
        for (int i = 0; i < N; ++i)
            dp.add(new HashMap<Integer, Integer>(0));

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int variance = nums[i] - nums[j];
                dp.get(i).put(variance, dp.get(j).getOrDefault(variance, 1) + 1);
                longest = Math.max(longest, dp.get(i).get(variance));
            }
        }

        return longest;
    }
}