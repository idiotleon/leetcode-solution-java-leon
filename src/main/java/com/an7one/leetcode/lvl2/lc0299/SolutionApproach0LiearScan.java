/**
 * https://leetcode.com/problems/bulls-and-cows/
 * 
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
 */
package com.an7one.leetcode.lvl2.lc0299;

public class SolutionApproach0LiearScan {
    public String getHint(String secret, String guess) {
        // sanity check
        if (secret == null || secret.isEmpty() || guess == null || guess.isEmpty() || secret.length() != guess.length())
            return "";

        final int L = secret.length();
        final char[] CHS_S = secret.toCharArray();
        final char[] CHS_G = guess.toCharArray();

        int bulls = 0;
        int cows = 0;
        final int[] FREQS = new int[10];

        for (int i = 0; i < L; ++i) {
            if (CHS_S[i] == CHS_G[i])
                ++bulls;
            else {
                if (FREQS[CHS_S[i] - '0']++ < 0)
                    ++cows;

                if (FREQS[CHS_G[i] - '0']-- > 0)
                    ++cows;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
