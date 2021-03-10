/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392950/Java-Sliding-Window-with-Clear-Explanation
 */
package com.an7one.leetcode.lvl3.lc1208;

public class SolutionApproach0SlidingWindow1 {
    public int equalSubstring(String s, String t, int maxCost) {
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() != t.length())
            return 0;

        final int L = s.length();
        final char[] CHS_S = s.toCharArray();
        final char[] CHS_T = t.toCharArray();

        final int[] COSTS = new int[L];
        for (int i = 0; i < L; ++i) {
            COSTS[i] = Math.abs(CHS_S[i] - CHS_T[i]);
        }

        int lo = 0, hi = 0;
        int longest = 0;
        int cost = 0;

        while (hi < L) {
            cost += COSTS[hi];

            while (cost > maxCost) {
                cost -= COSTS[lo];
                ++lo;
            }

            longest = Math.max(longest, hi - lo + 1);

            ++hi;
        }

        return longest;
    }
}
