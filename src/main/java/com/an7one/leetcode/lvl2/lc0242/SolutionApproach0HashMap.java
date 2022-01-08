/**
 * @author: Leon
 * https://leetcode.com/problems/valid-anagram/
 * Time Complexity:     O(`lenS` + `lenT`) ~ O(max(`lenS`, `lenT`))
 * Space Complexity:    O(26) ~ O(1)
 */
package com.an7one.leetcode.lvl2.lc0242;

import com.an7one.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HashMap {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        final int lenS = s.length();
        final int lenT = t.length();
        if (lenS != lenT) return false;

        int[] indexS = new int[26];
        int[] indexT = new int[26];
        for (int i = 0; i < lenS; ++i) {
            ++indexS[s.charAt(i) - 'a'];
            ++indexT[t.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            if (indexS[i] != indexT[i]) return false;
        }

        return true;
    }
}
