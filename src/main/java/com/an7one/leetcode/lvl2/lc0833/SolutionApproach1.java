/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/find-and-replace-in-string/discuss/130614/java-10-line-14ms-and-13-line-7ms-codes-both-use-StringBuilder-replace-from-end./203442
 */
package com.an7one.leetcode.lvl2.lc0833;

import java.util.Arrays;

public class SolutionApproach1 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        final int L = S.length();
        int[] sorted = new int[L];
        Arrays.fill(sorted, -1);

        final int N_IDXES = indexes.length;
        for (int i = 0; i < N_IDXES; ++i) {
            sorted[indexes[i]] = i;
        }

        for (int i = L - 1; i >= 0; --i) {
            if (sorted[i] == -1)
                continue;
            int j = sorted[i];
            String str = sources[j], target = targets[j];
            if (S.substring(i, i + str.length()).equals(str)) {
                S = S.substring(0, i) + target + S.substring(i + str.length());
            }
        }

        return S;
    }
}
