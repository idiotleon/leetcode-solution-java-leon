/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Time Complexity:     O(L) / O(1) + O(1) ~ O(L) / O(1)
 * Space Complexity:    O(1)
 * 
 * `res += lo`
 *  [i - 1, ..., j] is the subarray, of the minimum length, ending at `j`, which contains all three letters.
 *  The validity of the subarray can be extended to `idx == 0`.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
 *  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516955/Java-ELEGANT-No-Sliding-Window-EXPLAINED-(No-of-Sub-Strings-Ending-at-Curr-Index)/456665
 */
package com.zea7ot.leetcode.lvl3.lc1358;

public class SolutionApproach0LinearScan {
    public int numberOfSubstrings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] LAST_INDEXES = { -1, -1, -1 };

        int count = 0;
        for (int i = 0; i < L; ++i) {
            LAST_INDEXES[CHS[i] - 'a'] = i;
            count += 1 + Math.min(LAST_INDEXES[0], Math.min(LAST_INDEXES[1], LAST_INDEXES[2]));
        }

        return count;
    }
}