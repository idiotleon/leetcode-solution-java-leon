/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity:     O(LEN_S) + O(LEN_T) ~ O(LEN_S)
 * Space Complexity:    O(1) / O(LEN_S)
 * 
 * References:
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
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

        final int LEN_S = s.length(), LEN_P = p.length();

        int[] hash = new int[26];
        for (char ch : p.toCharArray())
            ++hash[ch - 'a'];

        char[] chs = s.toCharArray();
        int lo = 0, hi = 0, count = LEN_P;
        while (hi < LEN_S) {
            if (hash[chs[hi++] - 'a']-- > 0)
                --count;

            if (count == 0)
                ans.add(lo);

            if (hi - lo == LEN_P && hash[chs[lo++] - 'a']++ >= 0)
                ++count;
        }

        return ans;
    }
}