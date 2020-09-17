/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/bulb-switcher-iii/discuss/532538/JavaC%2B%2BPython-Straight-Forward-O(1)-Space
 */
package com.zea7ot.leetcode.lvl2.lc1375;

public class SolutionApproach0Greedy {
    public int numTimesAllBlue(int[] light) {
        // sanity check
        if (light == null || light.length == 0)
            return 0;

        final int N = light.length;
        int max = 0, count = 0;

        for (int i = 0; i < N; ++i) {
            max = Math.max(max, light[i]);
            if (max == i + 1)
                ++count;
        }

        return count;
    }
}