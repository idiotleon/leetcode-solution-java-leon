package com.idiotleon.leetcode.lvl4.lc0076;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`) ~ O(`LEN_S`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public String minWindow(String s, String t) {
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        final int lenS = s.length(), lenT = t.length();
        final char[] chsS = s.toCharArray(), chsT = t.toCharArray();

        // to build up the dictionary
        final int[] freqs = new int[128];
        for (int i = 0; i < lenT; ++i) {
            ++freqs[chsT[i]];
        }

        int lo = 0, count = lenT;
        String ans = "";

        for (int hi = 0; hi < lenS; ++hi) {
            // freq[s.charAt(right)] > 0 means s.charAt(right) is in t
            if (freqs[chsS[hi]] > 0)
                --count;
            // this will put chars that are not in t negative
            --freqs[chsS[hi]];
            // we have not found all letters yet
            if (count > 0)
                continue;

            // we have found all letters
            while (count == 0) {
                if (ans.length() == 0 || (hi - lo + 1) < ans.length())
                    ans = s.substring(lo, hi + 1);

                // to reduce the length till count > 0.
                // this automatically include the rightmost ones necessary if duplicates exist
                ++freqs[chsS[lo]];
                if (freqs[chsS[lo]] > 0)
                    ++count;

                ++lo;
            }
        }

        return ans;
    }
}