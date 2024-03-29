/**
 * https://leetcode.com/problems/palindromic-substrings/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome/144768
 *  https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome
 */
package com.idiotleon.leetcode.lvl3.lc0647;

public class SolutionApproach0ExtendPalindrome {
    public int countSubstrings(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        int count = 0;
        final int L = str.length();
        for (int i = 0; i < L; i++) {
            count += extendPalindrome(i, i, str);
            count += extendPalindrome(i, i + 1, str);
        }

        return count;
    }

    private int extendPalindrome(int lo, int hi, String str) {
        int count = 0;
        final int L = str.length();
        char[] chs = str.toCharArray();
        while (lo >= 0 && hi < L && chs[lo] == chs[hi]) {
            count++;
            lo--;
            hi++;
        }
        return count;
    }
}