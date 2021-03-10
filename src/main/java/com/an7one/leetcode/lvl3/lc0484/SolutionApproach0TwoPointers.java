package com.an7one.leetcode.lvl3.lc0484;

public class SolutionApproach0TwoPointers {
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

            reverse(lo, hi, ans);
            lo = hi + 1;
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
