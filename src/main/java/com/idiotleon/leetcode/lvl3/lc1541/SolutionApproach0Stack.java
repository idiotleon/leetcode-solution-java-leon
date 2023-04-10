/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/string/leetcode-1541-minimum-insertions-to-balance-a-parentheses-string/
 */
package com.idiotleon.leetcode.lvl3.lc1541;

public class SolutionApproach0Stack {
    // not necessary
    // private static final char OPEN_PAREN = '(';
    private static final char CLOSED_PAREN = ')';

    public int minInsertions(String s) {
        int ans = 0;

        int stack = 0;
        for (final char CH : s.toCharArray()) {
            if (CH == CLOSED_PAREN) {
                --stack;

                if (stack < 0) {
                    ++ans;
                    stack += 2;
                }
            } else {
                if ((stack & 1) == 1) {
                    --stack;
                    ++ans;
                }

                stack += 2;
            }
        }

        return ans + stack;
    }
}
