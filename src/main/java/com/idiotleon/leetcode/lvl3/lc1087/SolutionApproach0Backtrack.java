/**
 * https://leetcode.com/problems/brace-expansion/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/brace-expansion/discuss/327977/Classic-backtracking-solution
 */
package com.idiotleon.leetcode.lvl3.lc1087;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0Backtrack {
    private static final char OPEN_BRACE = '{';
    private static final char CLOSED_BRACE = '}';

    public String[] expand(String str) {
        List<String> ans = new ArrayList<>();
        dfs(0, new StringBuilder(), str, ans);

        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(int idx, StringBuilder builder, String str, List<String> res) {
        final int L = str.length();
        if (idx == L) {
            if (builder.length() > 0) {
                res.add(builder.toString());
            }

            return;
        }

        final char CH = str.charAt(idx);
        final int LEN = builder.length();

        if (CH == OPEN_BRACE) {
            List<Character> letters = new ArrayList<>();
            int hi = idx + 1;
            while (hi < L) {
                final char CHR = str.charAt(hi);
                if (CHR == CLOSED_BRACE)
                    break;
                if (Character.isLetter(CHR)) {
                    letters.add(CHR);
                }

                ++hi;
            }

            Collections.sort(letters);
            for (char ch : letters) {
                builder.append(ch);
                dfs(hi + 1, builder, str, res);
                builder.setLength(LEN);
            }
        } else if (Character.isLetter(CH)) {
            builder.append(CH);
            dfs(idx + 1, builder, str, res);
        }
    }
}
