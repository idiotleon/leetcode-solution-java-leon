/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity:     O(LEN_P)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0438;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0SlidingWindow1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (s == null || s.isEmpty() || p == null || p.isEmpty())
            return ans;

        final int LEN_S = s.length(), LEN_P = p.length();

        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++freq[p.charAt(i) - 'a'];
        }

        int count = 0;
        for (int i = 0; i < LEN_S; i++) {
            if (i >= LEN_P) {
                ++freq[s.charAt(i - LEN_P) - 'a'];
                if (freq[s.charAt(i - LEN_P) - 'a'] > 0) {
                    --count;
                }
            }

            --freq[s.charAt(i) - 'a'];

            if (freq[s.charAt(i) - 'a'] >= 0)
                ++count;
            if (count == LEN_P) {
                ans.add(i - count + 1);
            }
        }

        return ans;
    }
}