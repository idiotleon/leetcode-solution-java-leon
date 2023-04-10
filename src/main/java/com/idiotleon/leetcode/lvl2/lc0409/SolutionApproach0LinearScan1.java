/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(2 * 26) ~ O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0409;

public class SolutionApproach0LinearScan1 {
    public int longestPalindrome2(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];

        int ans = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                ++lowercase[ch - 'a'];
            else
                ++uppercase[ch - 'A'];
        }

        for (int i = 0; i < 26; i++) {
            ans += (lowercase[i] / 2) * 2;
            ans += (uppercase[i] / 2) * 2;
        }

        // can only have one char with odd numbers
        return ans == L ? ans : ans + 1;
    }
}