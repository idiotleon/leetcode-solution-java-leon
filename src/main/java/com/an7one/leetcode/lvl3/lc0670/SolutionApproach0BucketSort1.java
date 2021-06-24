package com.an7one.leetcode.lvl3.lc0670;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/maximum-swap/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * <p>
 * `buckets` to record the last position of digits (0 ~ 9) in the `num`
 * <p>
 * References:
 * https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BucketSort1 {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        final int L = digits.length;

        int[] buckets = new int[10];
        for (int i = 0; i < L; ++i) {
            buckets[digits[i] - '0'] = i;
        }

        int max = 9;
        for (int i = 0; i < L; ++i) {
            for (int k = max; k > digits[i] - '0'; --k) {
                if (buckets[k] > i) {
                    swap(i, buckets[k], digits);
                    return Integer.parseInt(new String(digits));
                }
            }

            max = digits[i] - '0';
        }

        return num;
    }

    private void swap(int i, int j, final char[] chs) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}