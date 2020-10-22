/**
 * https://leetcode.com/problems/push-dominoes/
 * 
 * Time Complexity:     O(`LEN`)
 * Space Complexity:    O(`LEN`)
 * 
 * References:
 *  https://leetcode.com/problems/push-dominoes/discuss/132482/Java-one-pass-in-place-13ms
 */
package com.zea7ot.leetcode.lvl3.lc0838;

public class SolutionApproach0LinearScan {
    private static final char PUSH_LEFT = 'L';
    private static final char PUSH_RIGHT = 'R';
    // not used
    // private static final char STANDING = '.';

    public String pushDominoes(String dominoes) {
        final int LEN = dominoes.length();
        final char[] CHS = dominoes.toCharArray();

        int lastIdxL = -1, lastIdxR = -1;
        for (int idx = 0; idx <= LEN; ++idx) {
            if (idx == LEN || CHS[idx] == PUSH_RIGHT) {
                if (lastIdxR > lastIdxL) { // R...R, to turn all to `R`
                    int i = lastIdxR; // a temporary pointer
                    while (i < idx) {
                        CHS[i++] = PUSH_RIGHT;
                    }
                }
                lastIdxR = idx;
            } else if (CHS[idx] == PUSH_LEFT) {
                if (lastIdxL > lastIdxR || (lastIdxR == -1 && lastIdxL == -1)) { // L...L, to turn all to `L`
                    int i = lastIdxL; // a temporary pointer
                    while (i < idx) {
                        CHS[++i] = PUSH_LEFT;
                    }
                } else { // R...L
                    lastIdxL = idx;
                    int lo = lastIdxR + 1, hi = lastIdxL - 1;
                    while (lo < hi) { // the one in the middle remains `STANDING`
                        CHS[lo++] = PUSH_RIGHT;
                        CHS[hi--] = PUSH_LEFT;
                    }
                }
            }
        }

        return new String(CHS);
    }
}
