/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array/123085
 */
package com.zea7ot.leetcode.lvl4.lc0616;

public class SolutionApproach0MarkPositions2 {
    private static final String TAG_START = "<b>";
    private static final String TAG_END = "</b>";

    public String addBoldTag(String s, String[] dict) {
        final int L = s.length();
        StringBuilder builder = new StringBuilder();
        int idxLast = 0, idxStart = 0, idxEnd = -1;

        while (idxStart < L) {
            for (String word : dict)
                if (s.startsWith(word, idxStart))
                    idxEnd = Math.max(idxEnd, idxStart + word.length());

            if (idxStart == idxEnd)
                builder.append(TAG_START).append(s.substring(idxLast, idxStart)).append(TAG_END);

            if (idxStart >= idxEnd) {
                builder.append(s.charAt(idxStart));
                idxLast = idxStart + 1;
            }

            ++idxStart;
        }

        if (idxEnd >= L)
            builder.append(TAG_START).append(s.substring(idxLast)).append(TAG_END);

        return builder.toString();
    }
}