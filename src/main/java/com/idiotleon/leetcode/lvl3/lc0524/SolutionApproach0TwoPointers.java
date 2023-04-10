/**
 * @author: Leon
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 *
 * Time Complexity:     O(`N` * `LEN_S`)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0524;

import java.util.List;

public class SolutionApproach0TwoPointers {
    public String findLongestWord(String s, List<String> d) {
        // not used
        // final int N = d.size();

        final int LEN_S = s.length();
        final char[] CHS_S = s.toCharArray();

        String longest = "";

        for (String word : d) {
            final int LEN_W = word.length();
            final char[] CHS_W = word.toCharArray();

            int idxS = 0, idxW = 0;

            while (idxS < LEN_S) {
                if (idxW < LEN_W && CHS_S[idxS] == CHS_W[idxW]) {
                    ++idxW;
                }

                ++idxS;
            }

            if (idxW == LEN_W) {
                if (LEN_W > longest.length()) {
                    longest = word;
                } else if (LEN_W == longest.length()) {
                    if (word.compareTo(longest) < 0) {
                        longest = word;
                    }
                }
            }
        }

        return longest;
    }
}
