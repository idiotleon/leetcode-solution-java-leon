/**
 * https://leetcode.com/problems/find-permutation/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-permutation/discuss/96613/Java-O(n)-clean-solution-easy-to-understand/101222
 */
package com.zea7ot.leetcode.lvl3.lc0484;

public class SolutionApproach0TwoPointers1 {
    private static final char DECREASING = 'D';

    public int[] findPermutation(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return new int[0];

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int[] ans = new int[L + 1];
        for (int i = 0; i <= L; ++i) {
            ans[i] = i + 1;
        }

        int lo = 0;
        while (lo < L) {
            int hi = lo;
            while (hi < L && CHS[hi] == DECREASING) {
                ++hi;
            }

            for (int k = hi - lo; k >= 0; --k, --hi) {
                ans[lo++] = hi + 1;
            }
        }

        return ans;
    }
}