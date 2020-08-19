/**
 * https://leetcode.com/problems/maximum-swap/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * `buckets` to record the last position of digits (0 ~ 9) in the `num`
 * 
 * References:
 *  https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
 */
package com.zea7ot.leetcode.lvl3.lc0670;

public class SolutionApproach0BucketSort1 {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        final int L = digits.length;

        int[] buckets = new int[10];
        for (int i = 0; i < L; ++i)
            buckets[digits[i] - '0'] = i;

        int max = 9;
        for (int i = 0; i < L; ++i) {
            for (int k = max; k > digits[i] - '0'; --k) {
                if (buckets[k] > i) {
                    swap(i, buckets[k], digits);
                    return Integer.valueOf(new String(digits));
                }
            }

            max = digits[i] - '0';
        }

        return num;
    }

    private void swap(int i, int j, final char[] CHS) {
        char temp = CHS[i];
        CHS[i] = CHS[j];
        CHS[j] = temp;
    }
}