/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 * 
 * Time Complexity:     O(L * 26) + O(N) ~ O(L) + O(N) ~ O(max(L, N))
 * Space Complexity:    O(L * 26) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/can-make-palindrome-from-substring/discuss/371849/JavaPython-3-3-codes-each%3A-prefix-sum-boolean-and-xor-of-characters'-frequencies-then-compare
 */
package com.an7one.leetcode.lvl4.lc1177;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0PrefixFreqs {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[][] PREFIX_FREQS = new int[L + 1][26];
        for (int i = 0; i < L; ++i) {
            // to copy the previous prefix frequencies
            PREFIX_FREQS[i + 1] = PREFIX_FREQS[i].clone();
            ++PREFIX_FREQS[i + 1][CHS[i] - 'a'];
        }

        for (int[] query : queries) {
            int sum = 0;
            int lo = query[0], hi = query[1];
            final int K = query[2];

            for (int i = 0; i < 26; ++i) {
                // modular for characters with even number of occurrences
                sum += (PREFIX_FREQS[hi + 1][i] - PREFIX_FREQS[lo][i]) % 2;
            }

            ans.add(sum / 2 <= K);
        }

        return ans;
    }
}
