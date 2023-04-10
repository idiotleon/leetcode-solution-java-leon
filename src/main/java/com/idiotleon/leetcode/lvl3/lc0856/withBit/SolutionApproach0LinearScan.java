package com.idiotleon.leetcode.lvl3.lc0856.withBit;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(1)
 *
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan {
    private static final char PAREN_OPEN = '(';
    private static final char PAREN_CLOSED = ')';

    public int scoreOfParentheses(String S) {
        final int L = S.length();
        int ans = 0, counter = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == PAREN_OPEN) counter++;
            else counter--;
            
            // depending on how many brackets are still open,
            // the weight/answer once they are closed are different
            if(S.charAt(i) == PAREN_CLOSED && S.charAt(i - 1) == PAREN_OPEN){
                ans += 1 << counter;
            }
        }
        
        return ans;
    }
}