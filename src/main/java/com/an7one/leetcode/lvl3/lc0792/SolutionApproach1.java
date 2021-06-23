package com.an7one.leetcode.lvl3.lc0792;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * <p>
 * Time Complexity: O()
 * Space Complexity: O(N * L)
 * N, number of words
 * L, length of words
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1 {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        List<List<StringBuilder>> waiting = new ArrayList<>();

        for (int c = 0; c <= 26; c++) {
            waiting.add(new ArrayList<>());
        }

        for (String word : words) {
            waiting.get(word.charAt(0) - 'a').add(new StringBuilder(word));
        }

        for (final char ch : S.toCharArray()) {
            List<StringBuilder> advance = waiting.get(ch - 'a');

            waiting.set(ch - 'a', new ArrayList<>());

            for (StringBuilder builder : advance) {
                builder.deleteCharAt(0);
                if (builder.length() != 0) {
                    waiting.get(builder.charAt(0) - 'a').add(builder);
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }
}