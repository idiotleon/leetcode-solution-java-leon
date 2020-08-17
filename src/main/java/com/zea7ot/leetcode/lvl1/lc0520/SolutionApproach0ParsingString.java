/**
 * https://leetcode.com/problems/detect-capital/
 * 
 * 
 */
package com.zea7ot.leetcode.lvl1.lc0520;

public class SolutionApproach0ParsingString {
    public boolean detectCapitalUse(String word) {
        final int L = word.length();
        char[] chs = word.toCharArray();

        int count = 0;
        for (char ch : chs)
            if (isCapital(ch))
                ++count;

        return (count == 0 || count == L || (count == 1 && isCapital(chs[0])));
    }

    private boolean isCapital(char ch) {
        return 'Z' - ch >= 0;
    }
}