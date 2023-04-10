/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Time Complexity:     O(L * 26) ~ O(L)
 * Space Complexiyt:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83193/Java-15ms-Solution-with-Two-auxiliary-array.-O(N)-time.
 */
package com.idiotleon.leetcode.lvl4.lc0358;

public class SolutionApproach0Greedy {
    private static final int ALPHABET = 26;

    public String rearrangeString(String s, int k) {
        // sanity check
        if (s == null || s.isEmpty())
            return "";
        if (k == 0)
            return s;

        final int L = s.length();
        int[] freq = new int[ALPHABET];
        for (char ch : s.toCharArray())
            ++freq[ch - 'a'];

        int[] nextValid = new int[ALPHABET];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            final int IDX = findValidMax(freq, nextValid, i);
            if (IDX == -1)
                return "";
            --freq[IDX];
            nextValid[IDX] = i + k;
            builder.append((char) (IDX + 'a'));
        }
        return builder.toString();
    }

    private int findValidMax(int[] freq, int[] nextValid, int index) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < ALPHABET; ++i) {
            if (freq[i] > 0 && freq[i] > max && index >= nextValid[i]) {
                max = freq[i];
                idx = i;
            }
        }

        return idx;
    }
}