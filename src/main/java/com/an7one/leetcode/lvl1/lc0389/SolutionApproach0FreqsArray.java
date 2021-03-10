/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-difference/
 * 
 * Time Complexity:     O(LEN_S) + O(LEN_T) ~ O(LEN_T)
 * Space Complexity:    O(1) / O(L)
 */
package com.an7one.leetcode.lvl1.lc0389;

public class SolutionApproach0FreqsArray {
    public char findTheDifference(String s, String t) {
        final int[] FREQS = new int[26];
        for (final char CH : s.toCharArray()) {
            ++FREQS[CH - 'a'];
        }

        for (final char CH : t.toCharArray()) {
            if (--FREQS[CH - 'a'] < 0)
                return CH;
        }

        return '#';
    }
}
