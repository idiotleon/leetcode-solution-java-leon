/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)/O(L)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-substrings-with-only-1s/discuss/731580/JavaC%2B%2BPython-Count
 */
package com.an7one.leetcode.lvl2.lc1513;

public class SolutionApproach0Math {
    private static final int MOD = (int) 1e9 + 7;

    public int numSub(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        int count = 0;
        int len = 0;

        for (final char CH : s.toCharArray()) {
            if (CH == '1')
                ++len;
            else
                len = 0;

            count = (count + len) % MOD;
        }

        return count;
    }
}