/**
 * https://leetcode.com/problems/diet-plan-performance/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/diet-plan-performance/discuss/371843/JavaPython-3-Sliding-window-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1176;

public class SolutionApproach0SlidingWindow {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        final int N = calories.length;

        int points = 0;

        // fixed-size window
        // calories during the consecutive k days
        int kDays = 0;

        for (int i = 0; i < N; ++i) {
            kDays += calories[i];

            if (i >= k - 1) {
                if (i > k - 1) {
                    kDays -= calories[i - k];
                }

                if (kDays < lower)
                    --points;
                if (kDays > upper)
                    ++points;
            }
        }

        return points;
    }
}
