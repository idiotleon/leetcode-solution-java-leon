/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0409;

public class SolutionApproach0LinearScan4 {
    public int longestPalindrome(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        int[] freq = new int[256];
        for (char ch : str.toCharArray())
            ++freq[ch];

        int odd = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                odd++;
            }
        }

        return odd == 0 ? L : L - odd + 1;
    }
}