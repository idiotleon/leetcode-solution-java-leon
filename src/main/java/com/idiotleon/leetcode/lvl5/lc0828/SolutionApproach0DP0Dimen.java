/**
 * https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * `LAST_INDEXES[i]`, the last position of character `CHS[i]` before i
 * ``
 * 
 * References:
 *  https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand/265186
 *  https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
 */
package com.idiotleon.leetcode.lvl5.lc0828;

public class SolutionApproach0DP0Dimen {
    // private static final int MOD = (int) 1e9 + 7;

    public int uniqueLetterString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int count = 0;

        final int[] LAST_INDEXES = new int[26];
        final int[] CONTRIBUTIONS = new int[26];
        int cur = 0;

        for (int i = 0; i < L; ++i) {
            final int IDX = CHS[i] - 'A';
            cur -= CONTRIBUTIONS[IDX];
            CONTRIBUTIONS[IDX] = (i - (LAST_INDEXES[IDX] - 1));
            cur += CONTRIBUTIONS[IDX];
            LAST_INDEXES[IDX] = i + 1;
            count += cur;
        }

        return count;
    }
}
