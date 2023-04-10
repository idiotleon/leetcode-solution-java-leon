package com.idiotleon.leetcode.lvl3.lc0856;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`)
 *
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0ApproachArray {
    private static final char PAREN_OPEN = '(';

    public int scoreOfParentheses(String S) {
        final int L = S.length();
        int[] ans = new int[30];
        int idx = 0;
        for(char c : S.toCharArray()){
            if(c == PAREN_OPEN) ans[++idx] = 0;
            else ans[idx - 1] += Math.max(ans[idx--] * 2, 1);
        }

        return ans[0];
    }
}