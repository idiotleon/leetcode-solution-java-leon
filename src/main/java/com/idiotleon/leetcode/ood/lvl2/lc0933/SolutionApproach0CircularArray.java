/**
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(`RANGE`) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.idiotleon.leetcode.ood.lvl2.lc0933;

public class SolutionApproach0CircularArray {
    private static final int RANGE = 3000 + 1;
    private final int[] TIME;

    public SolutionApproach0CircularArray() {
        this.TIME = new int[RANGE];
    }

    public int ping(int t) {
        int res = 0;
        TIME[t % RANGE] = t;

        for (int i = 0; i < RANGE; ++i) {
            if (TIME[i] != 0 && TIME[i] >= t - 3000) {
                ++res;
            }
        }

        return res;
    }
}
