/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity:     O(L ^ 3)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/492704/Easy100-Sliding-Window-Rolling-Counter
 */
package com.zea7ot.leetcode.lvl4.lc1316;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1RollingCounter {
    public int distinctEchoSubstrings(String text) {
        // sanity check
        if (text == null || text.isEmpty())
            return 0;

        final int L = text.length();
        final char[] CHS = text.toCharArray();
        Set<String> set = new HashSet<>();

        for (int len = 1; len <= L / 2; ++len) {
            int lo = 0, hi = len;
            int count = 0;

            while (lo < L - len) {
                if (CHS[lo] == CHS[hi])
                    ++count;
                else
                    count = 0;

                if (count == len) {
                    set.add(text.substring(lo - len + 1, lo + 1));
                    --count;
                }

                ++hi;
                ++lo;
            }
        }

        return set.size();
    }
}
