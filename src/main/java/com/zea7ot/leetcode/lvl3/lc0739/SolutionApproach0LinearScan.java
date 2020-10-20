/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/daily-temperatures/discuss/121787/C%2B%2B-Clean-code-with-explanation%3A-O(n)-time-and-O(1)-space-(beats-99.13)
 */
package com.zea7ot.leetcode.lvl3.lc0739;

public class SolutionApproach0LinearScan {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[0];
        final int N = T.length;

        int[] ans = new int[N];

        for (int lo = N - 1; lo >= 0; --lo) {
            int hi = lo + 1;

            while (hi < N && T[lo] >= T[hi]) {
                hi = ans[hi] > 0 ? hi + ans[hi] : N;
            }

            if (hi < N) {
                ans[lo] = hi - lo;
            }
        }

        return ans;
    }
}
