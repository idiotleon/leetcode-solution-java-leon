package com.an7one.leetcode.lvl4.lc1163;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/last-substring-in-lexicographical-order/">Description</a>
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(1)
 *
 * References:
 *  <a href="https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/363662/Short-python-code-O(n)-time-and-O(1)-space-with-proof-and-visualization/456308">Short Python Code</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public String lastSubstring(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";

        final int L = s.length();
        final char[] chs = s.toCharArray();
        int lo = 0, hi = 1, k = 0;

        while (hi + k < L) {
            if (chs[lo + k] == chs[hi + k]) {
                ++k;
                continue;
            }

            if (chs[lo + k] <= chs[hi + k]) {
                lo = hi;
            }

            ++hi;
            k = 0;
        }

        return s.substring(lo);
    }
}
