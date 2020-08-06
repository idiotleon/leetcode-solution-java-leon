/**
 * https://leetcode.com/problems/valid-square/
 * 
 * Time Complexity:     O(4) ~ O(1)
 * Space Complexity:    O(2) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/valid-square/discuss/103442/C++-3-lines-(unordered_set)/237363
 *  https://leetcode.com/problems/valid-square/discuss/103442/C%2B%2B-3-lines-(unordered_set)
 */
package com.zea7ot.lc.lvl3.lc0593;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Geometry {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3), distance(p1, p4),
                distance(p2, p3), distance(p2, p4), distance(p3, p4)));

        return !set.contains(0) && set.size() == 2;
    }

    private int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}