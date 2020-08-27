/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`) ~ O(`LEN_S`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0076;

public class SolutionApproach0SlidingWindow1 {
    public String minWindow(String s, String t) {
        // sanity check
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        final int LEN_S = s.length(), LEN_T = t.length();
        final char[] CHS_S = s.toCharArray(), CHS_T = t.toCharArray();

        // to build up the dictionary
        int[] freq = new int[128];
        for (int i = 0; i < LEN_T; ++i)
            ++freq[CHS_T[i]];

        int lo = 0, count = LEN_T;
        String ans = "";

        for (int hi = 0; hi < LEN_S; ++hi) {
            // freq[s.charAt(right)] > 0 means s.charAt(right) is in t
            if (freq[CHS_S[hi]] > 0)
                --count;
            // this will put chars that are not in t negative
            --freq[CHS_S[hi]];
            // we have not found all letters yet
            if (count > 0)
                continue;

            // we have found all letters
            while (count == 0) {
                if (ans.length() == 0 || (hi - lo + 1) < ans.length())
                    ans = s.substring(lo, hi + 1);

                // to reduce the length till count > 0.
                // this automatically include the rightmost ones necessary if duplicates exist
                ++freq[CHS_S[lo]];
                if (freq[CHS_S[lo]] > 0)
                    ++count;

                ++lo;
            }
        }

        return ans;
    }
}