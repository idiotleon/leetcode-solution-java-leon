/**
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(3) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/moving-stones-until-consecutive/discuss/282836/C%2B%2BJava-4-lines
 */
package com.zea7ot.leetcode.lvl3.lc1033;

import java.util.Arrays;

public class SolutionApproach0Math {
    public int[] numMovesStones(int a, int b, int c) {
        int[] sorted = { a, b, c };
        Arrays.sort(sorted);
        if (sorted[2] - sorted[0] == 2)
            return new int[] { 0, 0 };
        return new int[] { Math.min(sorted[1] - sorted[0], sorted[2] - sorted[1]) <= 2 ? 1 : 2,
                sorted[2] - sorted[0] - 2 };
    }
}