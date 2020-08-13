/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity:     O(LEN_S) + O(LEN_T) ~ O(LEN_S)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0438;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0SlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (s == null || s.isEmpty() || p == null || p.isEmpty())
            return ans;

        final int LEN_P = p.length(), LEN_S = s.length();
        int[] hash = new int[256];
        for (int i = 0; i < LEN_P; ++i)
            ++hash[p.charAt(i)];

        int lo = 0, hi = 0, count = LEN_P;
        while (hi < LEN_S) {
            if (hash[s.charAt(hi++)]-- > 0)
                --count;

            if (count == 0)
                ans.add(lo);

            if (hi - lo == LEN_P && hash[s.charAt(lo++)]++ >= 0)
                ++count;
        }

        return ans;
    }
}