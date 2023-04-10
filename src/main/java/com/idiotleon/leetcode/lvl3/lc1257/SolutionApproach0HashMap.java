/**
 * https://leetcode.com/problems/smallest-common-region/discuss/430500/JavaPython-3-Lowest-common-ancestor-w-brief-explanation-and-analysis.
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/smallest-common-region/discuss/430500/JavaPython-3-Lowest-common-ancestor-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl3.lc1257;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parents = new HashMap<>();
        Set<String> ancestors = new HashSet<>();

        for (List<String> region : regions) {
            final int SIZE = region.size();
            for (int i = 1; i < SIZE; ++i) {
                parents.put(region.get(i), region.get(0));
            }
        }

        while (region1 != null) {
            ancestors.add(region1);
            region1 = parents.get(region1);
        }

        while (!ancestors.contains(region2)) {
            region2 = parents.get(region2);
        }

        return region2;
    }
}
