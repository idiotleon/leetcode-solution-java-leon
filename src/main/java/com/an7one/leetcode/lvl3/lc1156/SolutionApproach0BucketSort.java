/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/swap-for-longest-repeated-character-substring/discuss/355852/Python-Groupby/449289
 *  https://leetcode.com/problems/swap-for-longest-repeated-character-substring/discuss/355852/Python-Groupby
 */
package com.an7one.leetcode.lvl3.lc1156;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BucketSort {
    public int maxRepOpt1(String text) {
        // sanity check
        if (text == null || text.isEmpty())
            return 0;

        final int L = text.length();
        final char[] CHS = text.toCharArray();

        // an alternative to HashMap
        // there are only 26 entries, corresponding to all alphabet letters
        final List<List<Integer>> LETTER_TO_INDEXES = new ArrayList<>();
        for (int i = 0; i < 26; ++i)
            LETTER_TO_INDEXES.add(new ArrayList<>());
        for (int i = 0; i < L; ++i)
            LETTER_TO_INDEXES.get(CHS[i] - 'a').add(i);

        int longest = 0;

        // to try to find the longest length, (alphabet) letter by (alphabet) letter
        // (26 alphabet letters)
        for (final List<Integer> INDEXES : LETTER_TO_INDEXES) {
            // total frequencies (of the alphabet letter)
            final int SIZE = INDEXES.size();

            // to initialize the `curLen` with 1,
            // because this is the assumption that there at least is one letter, 
            // for the upcoming process, at all times,
            // even there might not be any occurence at all (for this letter)
            int curLen = 1, prevLen = 0;
            // the local running length for the alphabet letter
            // to initialize `len` the same as `curLen`
            int len = 1;
            for (int i = 1; i < SIZE; ++i) {
                // to pick the the previous index
                final int IDX_PREV = INDEXES.get(i - 1);
                // to pick the current index
                final int IDX_CUR = INDEXES.get(i);

                // if they are contiguous
                // (if the the previous index and current index differs by 1)
                if (IDX_CUR == IDX_PREV + 1)
                    ++curLen;
                else {// if they are not contiguous
                      // if there is only 1 different letter, between the letters of the two indexes
                      // pick
                    prevLen = (IDX_CUR == IDX_PREV + 2) ? curLen : 0;
                    // to reset the process/counter
                    curLen = 1;
                }

                // to find the longest length (of the substring) for the letter
                len = Math.max(len, prevLen + curLen);
            }

            /*
             * (My personal explaination. Please correct me if I am wrong)
             * if ALL the characters (of this alphabet letter) can be connected, 
             *  (by "connected", I mean being connected with one swap)
             *  `len` == SIZE;
             * 
             * if not all the characters (of this alphabet letter) can be connected,
             *  the `len` should be added by 1, because of the swap;
             *
             * that `SIZE > len` only happens, because the initialization of `len`, 
             *  where there is no occurence of such an alphabet at all,
             *  i.e., `list.size() == 0`
             */
            longest = Math.max(longest, len + (len < SIZE ? 1 : 0));
        }

        return longest;
    }
}
