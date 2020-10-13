/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 * 
 * Time Complexity:     O(max(LEN_S, LEN_T)) ~ O(LEN_S)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109356/JAVA-two-pointer-solution-(12ms-beat-100)-with-explaination/211042
 */
package com.zea7ot.leetcode.lvl4.lc0727;

public class SolutionApproach0TwoPointers {
    public String minWindow(String S, String T) {
        String ans = "";
        // sanity check
        if (S.isEmpty() || T.isEmpty())
            return ans;

        final int LEN_S = S.length(), LEN_T = T.length();
        int idxS = 0, idxT = 0;
        int len = LEN_S + 1;

        final char[] CHS_S = S.toCharArray();
        final char[] CHS_T = T.toCharArray();

        while (idxS < LEN_S) {
            if (CHS_S[idxS] == CHS_T[idxT]) {
                ++idxT;
                if (idxT == LEN_T) { // all chars in `CHS_T` have been matched
                    // to check feasibility from left to right of `T`
                    int end = idxS + 1; // `idxS` is the last match index in `CHS_S`/`S`
                    // to check optimization from right to left of T
                    --idxT; // now 'idxT' is the last index in `CHS_T`/`T`
                    while (idxT >= 0) {
                        if (CHS_S[idxS] == CHS_T[idxT]) {
                            --idxT;
                        }
                        --idxS;
                    }

                    ++idxS; // first matching index in `CHS_S` has been found
                    ++idxT; //

                    // to record the current smallest candidate
                    if (end - idxS < len) {
                        len = end - idxS;
                        ans = S.substring(idxS, end); // [idxS, end) is the matching subsequence
                    }
                }
            }

            ++idxS;
        }

        return len == LEN_S + 1 ? "" : ans;
    }
}