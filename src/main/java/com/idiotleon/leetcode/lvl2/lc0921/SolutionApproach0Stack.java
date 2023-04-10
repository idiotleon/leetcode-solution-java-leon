/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 */
package com.idiotleon.leetcode.lvl2.lc0921;

public class SolutionApproach0Stack {
    public int minAddToMakeValid(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return 0;

        final int L = S.length();

        int ans = 0, stack = 0;
        for (int i = 0; i < L; ++i) {
            final char CH = S.charAt(i);

            if (CH == '(') {
                ++stack;
            } else if (CH == ')') {
                if (stack == 0)
                    ++ans;
                else
                    --stack;
            }
        }

        ans += stack;

        return ans;
    }
}