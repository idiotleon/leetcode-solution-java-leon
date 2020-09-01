/**
 * https://leetcode.com/problems/string-compression/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution
 */
package com.zea7ot.leetcode.lvl2.lc0443;

public class SolutionApproach0HighLowPointers {
    public int compress(char[] chs) {
        // sanity check
        if (chs == null || chs.length == 0)
            return 0;

        final int N = chs.length;

        int lo = 0, hi = 0;
        while (hi < N) {
            final char CH = chs[hi];
            int count = 0;
            while (hi < N && chs[hi] == CH) {
                ++hi;
                ++count;
            }

            chs[lo++] = CH;

            if (count != 1) {
                for (char ch : Integer.toString(count).toCharArray())
                    chs[lo++] = ch;
            }
        }

        return lo;
    }
}