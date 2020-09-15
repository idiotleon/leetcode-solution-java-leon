/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 * Time Complexity:     O(LEN(s) * NUM(dict)) + O(LEN(s)) ~ 
 * Space Complexity:    O()
 * 
 * References:
 *   https://leetcode.com/problems/add-bold-tag-in-string/discuss/104262/short-java-solution
 */
package com.zea7ot.leetcode.lvl4.lc0616;

public class SolutionApproach0SweepLine {
    private static final String TAG_OPEN = "<b>";
    private static final String TAG_CLOSED = "</b>";

    public String addBoldTag(String s, String[] dict) {
        final int L = s.length();

        int[] marks = new int[L + 1];
        for (String word : dict) {
            int idx = -1;
            while ((idx = s.indexOf(word, idx + 1)) >= 0) {
                ++marks[idx];
                --marks[idx + word.length()];
            }
        }

        StringBuilder builder = new StringBuilder();
        int prev = 0, idx = 0;
        while (idx <= L) {
            int cur = prev + marks[idx];

            if (cur > 0 && prev == 0)
                builder.append(TAG_OPEN);

            if (cur == 0 && prev > 0)
                builder.append(TAG_CLOSED);

            if (idx == L)
                break;

            builder.append(s.charAt(idx));
            prev = cur;
            ++idx;
        }

        return builder.toString();
    }
}