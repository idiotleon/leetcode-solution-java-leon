/**
 * https://leetcode.com/problems/shortest-way-to-form-string/
 * 
 * Time Complexity:     O(LEN_S * LEN_T)
 * Space Complexity:    O(LEN_S + LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-way-to-form-string/discuss/330938/Accept-is-not-enough-to-get-a-hire.-Interviewee-4-follow-up
 */
package com.idiotleon.leetcode.lvl3.lc1055;

public class SolutionApproach0TwoPointers {
    public int shortestWay(String source, String target) {
        final int LEN_S = source.length(), LEN_T = target.length();

        final char[] CHS_S = source.toCharArray();
        final char[] CHS_T = target.toCharArray();

        int[] freq = new int[26];
        for (char ch : CHS_S)
            ++freq[ch - 'a'];

        int ans = 1;
        int idxS = 0, idxT = 0;
        while (idxT < LEN_T) {
            if (freq[CHS_T[idxT] - 'a'] == 0)
                return -1;

            while (idxS < LEN_S && CHS_S[idxS] != CHS_T[idxT])
                ++idxS;

            // to reset `idxS`
            if (idxS == LEN_S) {
                idxS = -1;
                ++ans;
                --idxT;
            }

            ++idxT;
            ++idxS;
        }

        return ans;
    }
}