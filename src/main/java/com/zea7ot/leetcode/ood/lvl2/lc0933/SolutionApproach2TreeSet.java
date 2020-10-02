/**
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(`RANGE`) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.zea7ot.leetcode.ood.lvl2.lc0933;

import java.util.TreeSet;

public class SolutionApproach2TreeSet {
    private final TreeSet<Integer> TIME;

    public SolutionApproach2TreeSet() {
        this.TIME = new TreeSet<>();
    }

    public int ping(int t) {
        TIME.add(t);
        return TIME.tailSet(t - 3000).size();
    }
}
