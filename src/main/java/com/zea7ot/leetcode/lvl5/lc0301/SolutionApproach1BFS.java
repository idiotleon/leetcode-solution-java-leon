/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * Time Complexity:     O(L * (2 ^ (L - 1))) ~ O (L * (2 ^ L))
 *  T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
 * 
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
 */
package com.zea7ot.leetcode.lvl5.lc0301;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionApproach1BFS {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (s == null)
            return ans;

        Set<String> visited = new HashSet<String>();
        Deque<String> queue = new ArrayDeque<String>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            final int L = str.length();

            if (isValid(str)) {
                ans.add(str);
                found = true;
            }

            if (found)
                continue;

            // to generate all possible states
            for (int i = 0; i < L; ++i) {
                char ch = str.charAt(i);
                if (ch != '(' && ch != ')')
                    continue;

                String next = str.substring(0, i) + str.substring(i + 1);

                if (!visited.add(next))
                    continue;
                queue.add(next);
            }
        }

        return ans;
    }

    private boolean isValid(String str) {
        final int L = str.length();
        int count = 0;

        for (int i = 0; i < L; ++i) {
            char ch = str.charAt(i);
            if (ch == '(')
                ++count;
            if (ch == ')' && count-- == 0)
                return false;
        }

        return count == 0;
    }
}