/**
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/grumpy-bookstore-owner/discuss/299492/Java-one-pass-with-comments-sliding-window
 */
package com.idiotleon.leetcode.lvl2.lc1052;

public class SolutionApproach0SlidingWindow {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        final int N = customers.length;

        int totalCustomers = 0;
        int totalGrumpy = 0;
        int maxSave = 0;
        int save = 0;

        for (int i = 0; i < N; ++i) {
            totalCustomers += customers[i];
            totalGrumpy += customers[i] * grumpy[i];
            save += customers[i] * grumpy[i];

            if (i > X - 1) {
                save -= customers[i - X] * grumpy[i - X];
            }

            maxSave = Math.max(maxSave, save);
        }

        return totalCustomers - totalGrumpy + maxSave;
    }
}
