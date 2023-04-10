/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity:     O(`lenS`) + O(`lenP`) ~ O(`lenS`)
 * Space Complexity:    O(`lenS`) + O(26) ~ O(`lenS`)
 * 
 * References:
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
 */
package com.idiotleon.leetcode.lvl2.lc0438;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length())
            return ans;

        final int lenS = s.length(), lenP = p.length();

        int[] freqs = new int[26];
        for (final char ch : p.toCharArray()) {
            ++freqs[ch - 'a'];
        }

        final char[] chs = s.toCharArray();
        int lo = 0, hi = 0, count = lenP;
        while (hi < lenS) {
            if (freqs[chs[hi] - 'a']-- > 0)
                --count;

            if (count == 0)
                ans.add(lo);

            if (hi - lo + 1 == lenP && freqs[chs[lo++] - 'a']++ >= 0)
                ++count;

            ++hi;
        }

        return ans;
    }
}