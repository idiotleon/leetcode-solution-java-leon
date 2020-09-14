/**
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/363662/Short-python-code-O(n)-time-and-O(1)-space-with-proof-and-visualization/456308
 */
package com.zea7ot.leetcode.lvl4.lc1163;

public class SolutionApproach0SlidingWindow1 {
    public String lastSubstring(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        int lo = 0, hi = 1, k = 0;

        while (hi + k < L) {
            if (CHS[lo + k] == CHS[hi + k]) {
                ++k;
                continue;
            }

            if (CHS[lo + k] > CHS[hi + k]) {
                ++hi;
            } else {
                lo = hi;
                hi = lo + 1;
            }

            k = 0;
        }

        return s.substring(lo);
    }
}
