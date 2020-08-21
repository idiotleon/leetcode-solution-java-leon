/**
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/one-edit-distance/discuss/50107/Accepted-clean-Java-solution-with-explanation-(two-pointers)
 */
package com.zea7ot.leetcode.lvl4.lc0161;

public class SolutionApproach0TwoPointers1 {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one
                                              // char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char
                                                  // from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }

        // All previous chars are the same, the only possibility is deleting the end
        // char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }
}