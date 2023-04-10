/**
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Time Complexity:     O(lg(N))
 *  N, number of pings
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.idiotleon.leetcode.ood.lvl2.lc0933;

import java.util.TreeMap;

public class SolutionApproach2TreeMap {
    private TreeMap<Integer, Integer> TIME;

    public SolutionApproach2TreeMap() {
        this.TIME = new TreeMap<>();
    }

    public int ping(int t) {
        TIME.put(t, 1 + TIME.size());
        return TIME.tailMap(t - 3000).size();
    }
}
