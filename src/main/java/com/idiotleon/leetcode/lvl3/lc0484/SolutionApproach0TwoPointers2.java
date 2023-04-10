/**
 * https://leetcode.com/problems/find-permutation/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-permutation/solution/
 */
package com.idiotleon.leetcode.lvl3.lc0484;

public class SolutionApproach0TwoPointers2 {
    private static final char DECREASING = 'D';

    public int[] findPermutation(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return new int[0];

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int[] ans = new int[L + 1];
        ans[0] = 1;
        int i = 1;

        while (i <= L) {
            ans[i] = i + 1;
            int j = i;
            if (CHS[i - 1] == DECREASING) {
                while (i <= L && CHS[i - 1] == DECREASING) {
                    ++i;
                }

                for (int k = j - 1, val = i; k <= i - 1; ++k, --val) {
                    ans[k] = val;
                }
            } else {
                ++i;
            }
        }

        return ans;
    }
}