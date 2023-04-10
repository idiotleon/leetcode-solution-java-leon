/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.idiotleon.leetcode.lvl2.lc0409;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0LinearScan3 {
    public int longestPalindrome(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < L; i++) {
            if (set.contains(str.charAt(i))) {
                set.remove(str.charAt(i));
                count++;
            } else {
                set.add(str.charAt(i));
            }
        }

        if (!set.isEmpty())
            return count * 2 + 1;
        return count * 2;
    }
}