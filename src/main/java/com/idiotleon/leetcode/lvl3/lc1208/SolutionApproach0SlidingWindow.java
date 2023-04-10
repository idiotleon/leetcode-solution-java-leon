/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392837/JavaC%2B%2BPython-Sliding-Window
 *  https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392857/C%2B%2BJava-Sliding-Window-O(n)-or-O(1)
 */
package com.idiotleon.leetcode.lvl3.lc1208;

public class SolutionApproach0SlidingWindow {
    public int equalSubstring(String s, String t, int maxCost) {
        // sanity check, not required
        // if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() !=
        // t.length())
        // return 0;

        final int L = s.length();
        final char[] CHS_S = s.toCharArray();
        final char[] CHS_T = t.toCharArray();

        int lo = 0, hi = 0;

        while (hi < L) {
            maxCost -= Math.abs(CHS_S[hi] - CHS_T[hi]);

            if (maxCost < 0) {
                maxCost += Math.abs(CHS_S[lo] - CHS_T[lo]);
                ++lo;
            }

            ++hi;
        }

        return hi - lo;
    }
}
