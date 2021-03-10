/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1) + O(26) ~ O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/unique-substrings-in-wraparound-string/discuss/95439/Concise-Java-solution-using-DP/99890
 *  https://leetcode.com/problems/unique-substrings-in-wraparound-string/discuss/95439/Concise-Java-solution-using-DP
 */
package com.an7one.leetcode.lvl4.lc0467;

public class SolutionApproach0SlidingWindow {
    public int findSubstringInWraproundString(String p) {
        // sanity check
        if (p == null || p.isEmpty())
            return 0;

        final int L = p.length();
        int max = 1;

        final int[] FREQS = new int[26];
        final char[] CHS = p.toCharArray();

        for (int i = 0; i < L; ++i) {
            if (i > 0) {
                int diff = CHS[i] - CHS[i - 1];
                if (diff == 1 || diff == -25) {
                    ++max;
                } else {
                    max = 1;
                }
            }

            int idx = CHS[i] - 'a';
            FREQS[idx] = Math.max(FREQS[idx], max);
        }

        int total = 0;
        for (int freq : FREQS) {
            total += freq;
        }

        return total;
    }
}
