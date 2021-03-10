/**
 * https://leetcode.com/problems/statistics-from-a-large-sample/
 * 
 * Time Complexity:     O(`RANGE`)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/statistics-from-a-large-sample/discuss/317857/Java-Simple-2-pass-code-w-comments-and-explanation.
 */
package com.an7one.leetcode.lvl4.lc1093;

public class SolutionApproach0Math {
    private static final int RANGE = 256;

    public double[] sampleStats(int[] count) {
        int total = 0, mode = 0;
        double median = 0, min = -1, max = 0, avg = 0, sum = 0;

        for (int i = 0; i < RANGE; ++i) {
            if (count[i] > 0) {
                total += count[i];
                if (min < 0)
                    min = i;
                max = i;
                sum += i * count[i];
                if (count[i] > count[mode])
                    mode = i;
            }
        }

        avg = sum / total;
        if (total == 1)
            median = sum;
        int median1 = (total + 1) / 2, median2 = total / 2 + 1;

        int cnt = 0;
        for (int i = 0; i < RANGE; ++i) {
            if (total <= 1)
                break;

            if (cnt < median1 && cnt + count[i] >= median1) {
                median += i / 2.0d;
            }

            if (cnt < median2 && cnt + count[i] >= median2) {
                median += i / 2.0d;
            }

            cnt += count[i];
        }

        return new double[] { min, max, avg, median, mode };
    }
}
