/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`) ~ O(`LEN_S`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0076;

public class SolutionApproach0SlidingWindow {
    public String minWindow(String s, String t) {
        String shortest = "";
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return shortest;

        final int LEN_S = s.length(), LEN_T = t.length();
        final char[] CHS_S = s.toCharArray(), CHS_T = t.toCharArray();

        int[] freq = new int[128];
        for (char ch : CHS_T)
            ++freq[ch];

        int lo = 0, hi = 0;
        int count = LEN_T;

        while (hi < LEN_S) {
            if (freq[CHS_S[hi]]-- > 0)
                --count;
            // not logically necessary.
            // better readability if added.
            // if added, please take care of `++hi`.
            // if(count > 0) continue;

            while (count == 0) {
                if (shortest.isEmpty() || (hi - lo + 1) < shortest.length())
                    shortest = s.substring(lo, hi + 1);

                if (++freq[CHS_S[lo]] > 0)
                    ++count;
                ++lo;
            }

            ++hi;
        }

        return shortest;
    }
}