/**
 * https://leetcode.com/problems/find-the-difference/
 * 
 * Time Complexity:     O(LEN_S + LEN_T) ~ O(LEN_T)
 * Space Complexity:    O(1) / O(LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-difference/discuss/86825/Java-solution-using-bit-manipulation
 */
package com.zea7ot.leetcode.lvl1.lc0389;

public class SolutionApproach0BitXOR {
    public char findTheDifference(String s, String t) {
        char ch = 0;

        for (final char CH : s.toCharArray()) {
            ch ^= CH;
        }

        for (final char CH : t.toCharArray()) {
            ch ^= CH;
        }

        return ch;
    }
}
