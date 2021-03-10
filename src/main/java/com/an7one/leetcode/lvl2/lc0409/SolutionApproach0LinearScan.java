/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(256) ~ O(1)
 */
package com.an7one.leetcode.lvl2.lc0409;

public class SolutionApproach0LinearScan {
    public int longestPalindrome(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        int[] freq = new int[256];
        for (char ch : s.toCharArray())
            ++freq[ch];

        int ans = 0, odd = 0;
        for (int num : freq) {
            if (num % 2 == 0)
                ans += num;
            else {
                ans += num - 1;
                odd = 1;
            }
        }

        return ans + odd;
    }
}