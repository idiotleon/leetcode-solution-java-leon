package com.an7one.leetcode.lvl1.lc0058;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * <p>
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1LastIndexOf {
    public int lengthOfLastWord(String s) {
        final int L = s.trim().length();
        return L - s.trim().lastIndexOf(" ") - 1;
    }
}