/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://github.com/huanminwu/LeetCode/blob/master/LeetCode_String_III_KMP_RabinKarp.docx
 * 
 *  about why a local set
 *  https://leetcode.com/problems/increasing-subsequences/discuss/97130/Java-20-lines-backtracking-solution-using-set-beats-100./101617 
 */
package com.an7one.leetcode.lvl4.lc1316;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1KMPAlgorithm {
    public int distinctEchoSubstrings(String text) {
        // sanity check
        if (text == null || text.isEmpty())
            return 0;

        final int L = text.length();
        final char[] CHS = text.toCharArray();
        Set<String> set = new HashSet<>();

        for (int s = 0; s < L; ++s) {
            final int[] KMP = new int[L];
            int i = 1, j = 0;
            while (s + i < L) {
                if (CHS[s + i] == CHS[s + j]) {
                    KMP[i++] = ++j;

                    // must be of even length
                    if (i % 2 == 1)
                        continue;
                    // if duplicate as half,
                    // the remaining prefix length must be
                    // divisible to total length
                    if ((i / 2) % (i - j) == 0) {
                        set.add(text.substring(s, s + i));
                    }
                } else if (j == 0) {
                    ++i;
                } else {
                    j = KMP[j - 1];
                }
            }
        }

        return set.size();
    }
}