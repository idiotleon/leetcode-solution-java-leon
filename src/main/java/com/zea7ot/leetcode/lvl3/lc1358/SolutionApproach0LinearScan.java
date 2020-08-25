/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 */
package com.zea7ot.leetcode.lvl3.lc1358;

public class SolutionApproach0LinearScan {
    public int numberOfSubstrings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        char[] chs = s.toCharArray();

        int[] lastIdx = { -1, -1, -1 };

        int count = 0;
        for (int i = 0; i < L; ++i) {
            lastIdx[chs[i] - 'a'] = i;
            count += 1 + Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2]));
        }

        return count;
    }
}