/**
 * https://leetcode.com/problems/permutation-in-string/
 * 
 * Time Complexity:     O(26 * (LEN2 - LEN1)) ~ O(LEN2)
 * Space Complexity:    O(LEN1 + LEN2) ~ O(max(LEN1, LEN2)) ~ O(LEN2)
 */
package com.zea7ot.leetcode.lvl2.lc0567;

public class SolutionApproach0RollingHash {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
            return false;

        final int LEN1 = s1.length();
        final int LEN2 = s2.length();
        if (LEN1 > LEN2)
            return false;

        final char[] CHS1 = s1.toCharArray();
        final char[] CHS2 = s2.toCharArray();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < LEN1; ++i) {
            ++freq1[CHS1[i] - 'a'];
            ++freq2[CHS2[i] - 'a'];
        }

        for (int i = 0; i < LEN2 - LEN1; ++i) {
            if (matches(freq1, freq2))
                return true;
            ++freq2[CHS2[i + LEN1] - 'a'];
            --freq2[CHS2[i] - 'a'];
        }

        return matches(freq1, freq2);
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; ++i)
            if (freq1[i] != freq2[i])
                return false;

        return true;
    }
}
