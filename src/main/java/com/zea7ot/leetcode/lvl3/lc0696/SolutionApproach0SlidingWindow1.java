/**
 * https://leetcode.com/problems/count-binary-substrings/discuss/108625/JavaC%2B%2BPython-Easy-and-Concise-with-Explanation
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * First, to count the number of 1 or 0 grouped consecutively.
 *  For example "0110001111" will be [1, 2, 3, 4].
 * 
 * Second, for any possible substrings with 1 and 0 grouped consecutively, 
 *  the number of valid substring will be the minimum number of 0 and 1.
 *  For example "0001111", will be min(3, 4) = 3, ("01", "0011", "000111")
 * 
 * 
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108625/JavaC%2B%2BPython-Easy-and-Concise-with-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0696;

public class SolutionApproach0SlidingWindow1 {
    public int countBinarySubstrings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int cur = 1;
        int prev = 0;
        int count = 0;

        for (int i = 1; i < L; ++i) {
            if (CHS[i - 1] == CHS[i])
                ++cur;
            else {
                count += Math.min(cur, prev);
                prev = cur;
                cur = 1;
            }
        }

        return count + Math.min(cur, prev);
    }
}
