package com.an7one.leetcode.lvl4.lc0076;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`) ~ O(`LEN_S`)
 * Space Complexity:    O(128) ~ O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public String minWindow(String s, String t) {
        String shortest = "";
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return shortest;

        final int lenS = s.length(), lenT = t.length();
        final char[] chsS = s.toCharArray(), chsT = t.toCharArray();

        final int[] freqs = new int[128];
        for (char ch : chsT) {
            ++freqs[ch];
        }

        int lo = 0, hi = 0;
        int count = lenT;

        while (hi < lenS) {
            if (freqs[chsS[hi]]-- > 0) {
                --count;
            }
            // not logically necessary.
            // better readability if added.
            // if added, please take care of `++hi`.
            // if(count > 0) continue;

            while (count == 0) {
                if (shortest.isEmpty() || (hi - lo + 1) < shortest.length())
                    shortest = s.substring(lo, hi + 1);

                if (++freqs[chsS[lo]] > 0)
                    ++count;

                ++lo;
            }

            ++hi;
        }

        return shortest;
    }
}