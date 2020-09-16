/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl2.lc0038;

public class SolutionApproach0ParsingString {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = countIdx(res);
        }

        return res;
    }

    private String countIdx(String str) {
        final int L = str.length();
        final char[] CHS = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        char ch = str.charAt(0);
        int count = 1;
        for (int i = 1; i < L; ++i) {
            if (CHS[i] == ch)
                ++count;
            else {
                builder.append(count);
                builder.append(ch);
                ch = CHS[i];
                count = 1;
            }
        }

        builder.append(count);
        builder.append(ch);

        return builder.toString();
    }
}