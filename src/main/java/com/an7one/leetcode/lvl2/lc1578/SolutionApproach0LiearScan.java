/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/discuss/831569/java-one-pass-with-a-little-math-with-clear-comments-ol
 */
package com.an7one.leetcode.lvl2.lc1578;

public class SolutionApproach0LiearScan {
    public int minCost(String s, int[] costs) {
        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int idx = 1;
        int cost = 0;
        while (idx < L) {
            if (CHS[idx - 1] == CHS[idx]) {
                int sum = costs[idx - 1];
                int max = costs[idx - 1];

                while (idx < L && CHS[idx - 1] == CHS[idx]) {
                    sum += costs[idx];
                    max = Math.max(max, costs[idx]);
                    ++idx;
                }

                cost += (sum - max);
            }

            ++idx;
        }

        return cost;
    }
}
