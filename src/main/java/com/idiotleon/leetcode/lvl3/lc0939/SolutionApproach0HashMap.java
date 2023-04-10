/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle/discuss/192025/Java-N2-Hashmap
 */
package com.idiotleon.leetcode.lvl3.lc0939;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public int minAreaRect(int[][] points) {
        // sanity check
        if (points == null || points.length == 0)
            return 0;

        final int N = points.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int[] p1 = points[i], p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;

                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1]))
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}