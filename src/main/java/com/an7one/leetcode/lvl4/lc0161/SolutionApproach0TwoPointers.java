/**
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/one-edit-distance/discuss/50107/Accepted-clean-Java-solution-with-explanation-(two-pointers)/50637
 */
package com.an7one.leetcode.lvl4.lc0161;

public class SolutionApproach0TwoPointers {
    public boolean isOneEditDistance(String s, String t) {
        // sanity check
        if (s.isEmpty() && t.isEmpty() || s.equals(t))
            return false;

        final int LEN_S = s.length(), LEN_T = t.length();

        if (LEN_S > LEN_T)
            return isOneEditDistance(t, s);

        int idx = 0;
        while (idx < LEN_S) {
            if (s.charAt(idx) != t.charAt(idx))
                return s.substring(idx + 1).equals(t.substring(idx + 1))
                        || s.substring(idx).equals(t.substring(idx + 1));
            ++idx;
        }

        return LEN_S + 1 == LEN_T;
    }
}