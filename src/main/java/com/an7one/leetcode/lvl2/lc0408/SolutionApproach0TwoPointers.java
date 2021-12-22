/**
 * https://leetcode.com/problems/valid-word-abbreviation/
 * <p>
 * Time Complexity:     O(max(`lenW`, `lenAbbr`))
 * Space Complexity:    O(1)/O(`lenW` + `lenAbbr`)
 * <p>
 * References:
 * https://leetcode.com/problems/valid-word-abbreviation/discuss/89523/Short-and-easy-to-understand-Java-Solution/94182
 */
package com.an7one.leetcode.lvl2.lc0408;

import com.an7one.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TwoPointers {
    public boolean validWordAbbreviation(String word, String abbr) {
        final int lenW = word.length(), lenAbbr = abbr.length();
        final char[] chsWord = word.toCharArray();
        final char[] chsAbbr = abbr.toCharArray();
        int number = 0;
        int i = 0, j = 0;

        while (i < lenW && j < lenAbbr) {
            if (Character.isDigit(chsAbbr[j])) {
                number = number * 10 + (chsAbbr[j] - '0');
                if (number == 0)
                    return false;
                ++j;
            } else {
                i += number;
                if (i >= lenW || chsWord[i] != chsAbbr[j])
                    return false;
                number = 0;
                ++i;
                ++j;
            }
        }

        i += number;
        return i == lenW && j == lenAbbr;
    }
}