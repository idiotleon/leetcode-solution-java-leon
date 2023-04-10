package com.idiotleon.leetcode.lvl3.lc0856;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Solution0ApproachStack {
    private static final char PAREN_OPEN = '(';

    public int scoreOfParentheses(String S) {
        final int L = S.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for(char c : S.toCharArray()){
            if(c == PAREN_OPEN){
                stack.addLast(cur);
                // to reset the counter
                cur = 0;
            }else{
                cur = stack.removeLast() + Math.max(cur * 2, 1);
            }
        }
        
        return cur;
    }
}