/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 * Time Complexity:     O((LEN(s) ^ 2) * NUM(dict)) + O(L) ~ O((LEN(s) ^ 2) * NUM(dict))
 * Space Complexity:    O()
 * 
 * References:  
 *  https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array
 */
package com.an7one.leetcode.lvl4.lc0616;

public class SolutionApproach0MarkPositions {
    private static final String TAG_OPEN = "<b>";
    private static final String TAG_CLOSED = "</b>";

    public String addBoldTag(String s, String[] dict) {
        final int L = s.length();
        boolean[] isBold = new boolean[L];
        for (String word : dict) {
            int idxStart = 0;
            while (idxStart >= 0) {
                idxStart = s.indexOf(word, idxStart);
                if (idxStart < 0)
                    break;
                int idxEnd = idxStart + word.length();
                for (int i = idxStart; i < idxEnd; ++i)
                    isBold[i] = true;

                ++idxStart;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            if (isBold[i] && (i - 1 < 0 || !isBold[i - 1]))
                builder.append(TAG_OPEN);

            builder.append(s.charAt(i));

            if (isBold[i] && (i + 1 == L || !isBold[i + 1]))
                builder.append(TAG_CLOSED);
        }
        return builder.toString();
    }
}