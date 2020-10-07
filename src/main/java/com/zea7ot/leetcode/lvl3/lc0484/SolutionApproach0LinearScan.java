/**
 * https://leetcode.com/problems/find-permutation/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 *  O(L), consumed by the answer array
 * 
 * References:
 *  https://leetcode.com/problems/find-permutation/discuss/96613/Java-O(n)-clean-solution-easy-to-understand
 */
package com.zea7ot.leetcode.lvl3.lc0484;

public class SolutionApproach0LinearScan {
    private static final char DECREASING = 'D';

    public int[] findPermutation(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return new int[0];

        final int L = s.length();
        int[] ans = new int[L + 1];
        for (int i = 0; i <= L; ++i) {
            ans[i] = i + 1;
        }

        final char[] CHS = s.toCharArray();
        for (int hi = 0; hi < L; ++hi) {
            if (CHS[hi] == DECREASING) {
                int lo = hi;
                while (hi < L && CHS[hi] == DECREASING)
                    ++hi;
                reverse(lo, hi, ans);
            }
        }

        return ans;
    }

    private void reverse(int lo, int hi, int[] nums) {
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            ++lo;
            --hi;
        }
    }
}