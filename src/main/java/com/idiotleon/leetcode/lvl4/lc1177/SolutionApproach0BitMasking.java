/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 * 
 * Time Complexity:     O(L * 26) + O(N) ~ O(L) + O(N) ~ O(max(L, N))
 * Space Complexity:    O(L * 26) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/can-make-palindrome-from-substring/discuss/371849/JavaPython-3-3-codes-each%3A-prefix-sum-boolean-and-xor-of-characters'-frequencies-then-compare
 */
package com.idiotleon.leetcode.lvl4.lc1177;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BitMasking {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int[] odds = new int[L + 1];
        for (int i = 0; i < L; ++i)
            odds[i + 1] = odds[i] ^ 1 << CHS[i] - 'a';

        for (int[] query : queries) {
            int lo = query[0], hi = query[1];
            final int K = query[2];

            ans.add(Integer.bitCount(odds[hi + 1] ^ odds[lo]) / 2 <= K);
        }

        return ans;
    }
}
