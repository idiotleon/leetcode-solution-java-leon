/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * 
 * Time Complexity:     O(5 * L) ~ O(L)
 * Space Complexity:    O(L) / O(1) + O(5) ~ O(L) / O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1456;

public class SolutionApproach0SlidingWindow {
    // private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a',
    // 'e', 'i', 'o', 'u'));
    private static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };

    public int maxVowels(String s, int k) {

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int lo = 0, hi = 0;
        int vowels = 0;
        int most = 0;

        while (hi < L) {
            if (isVowel(CHS[hi])) {
                ++vowels;
            }

            final int LEN = hi - lo + 1;
            if (LEN > k) {
                if (isVowel(CHS[lo])) {
                    --vowels;
                }

                ++lo;
            }

            most = Math.max(most, vowels);
            ++hi;
        }

        return most;
    }

    private boolean isVowel(final char CH) {
        // return VOWELS.contains(CH);
        for (final char VOWEL : VOWELS) {
            if (VOWEL == CH)
                return true;
        }

        return false;
    }
}
