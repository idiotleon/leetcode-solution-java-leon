/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L) ~ O(1)
 * 
 *  `res += lo`
 *   [i - 1, ..., j] is the subarray, of the minimum length, ending at `j`, which contains all three letters.
 *   The validity of the subarray can be extended to `idx == 0`.
 * 
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC++Python-Easy-and-Concise/656186
 */
package com.idiotleon.leetcode.lvl3.lc1358;

public class SolutionApproach0SlidingWindow {
    public int numberOfSubstrings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] FREQS = { 0, 0, 0 };

        int lo = 0, hi = 0;
        int count = 0;

        while (hi < L) {
            ++FREQS[CHS[hi] - 'a'];

            while (isValid(FREQS)) {
                --FREQS[CHS[lo] - 'a'];
                ++lo;
            }

            count += lo;
            ++hi;
        }

        return count;
    }

    private boolean isValid(final int[] FREQS) {
        return FREQS[0] > 0 && FREQS[1] > 0 && FREQS[2] > 0;
    }
}