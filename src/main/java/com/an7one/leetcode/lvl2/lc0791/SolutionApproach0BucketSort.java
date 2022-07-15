package com.an7one.leetcode.lvl2.lc0791;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/custom-sort-string/">LC0791</a>
 * <p>
 * Time Complexity:     O(LEN(S) + LEN(T))
 * Space Complexity:    O(LEN(T))
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/custom-sort-string/discuss/116615/JavaPython-3-one-Java-10-liner-Python-6-liner-and-2-liner-solutions-w-comment">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BucketSort {
    public String customSortString(String S, String T) {
        final int[] freqs = new int[26];
        for (char ch : T.toCharArray()) {
            ++freqs[ch - 'a'];
        }

        final StringBuilder builder = new StringBuilder();
        for (char ch : S.toCharArray()) {
            while (freqs[ch - 'a']-- > 0) {
                builder.append(ch);
            }
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            while (freqs[ch - 'a']-- > 0) {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}