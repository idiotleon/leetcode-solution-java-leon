/**
 * https://leetcode.com/problems/permutation-in-string/
 * 
 * Time Complexity:     O((LEN2 - LEN1) * LEN1) ~ O(LEN2 * LEN1) 
 * Space Complexity:    O(LEN1 + LEN2) ~ O(max(LEN1, LEN2)) ~ O(LEN2)
 */
package com.idiotleon.leetcode.lvl2.lc0567;

public class SolutionApproach1TwoPointers {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
            return false;

        final int LEN1 = s1.length(), LEN2 = s2.length();
        if (LEN1 > LEN2)
            return false;

        int[] freq1 = new int[26];
        for (char ch : s1.toCharArray())
            ++freq1[ch - 'a'];

        for (int i = 0; i <= LEN2 - LEN1; ++i) {
            int[] freq2 = new int[26];
            for (int j = 0; j < LEN1; ++j)
                ++freq2[s2.charAt(i + j) - 'a'];

            if (matches(freq1, freq2))
                return true;
        }

        return false;
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; ++i)
            if (freq1[i] != freq2[i])
                return false;

        return true;
    }
}
