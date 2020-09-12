/**
 * https://leetcode.com/problems/count-binary-substrings/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/113793
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/221785
 */
package com.zea7ot.leetcode.lvl3.lc0696;

public class SolutionApproach0SlidingWindow {
    public int countBinarySubstrings(String s) {
        // santiy check
        if (s == null || s.isEmpty())
            return 0;

        int zeros = 0, ones = 0;
        int prev = -1;
        int count = 0;

        for (final char CH : s.toCharArray()) {
            if (CH == '0') {
                if (prev == 1)
                    zeros = 0;
                ++zeros;
                prev = 0;
            } else {
                if (prev == 0)
                    ones = 0;
                ++ones;
                prev = 1;
            }

            if ((prev == 1 && zeros >= ones) || (prev == 0 && ones >= zeros))
                ++count;
        }

        return count;
    }
}
