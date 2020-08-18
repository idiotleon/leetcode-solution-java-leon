/**
 * https://leetcode.com/problems/total-hamming-distance/
 * 
 * Time Complexity:     O(32 * N) ~ O(N)
 * Space Complexity:    O(32 * 2) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space/100726
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96243/Share-my-O(n)-C++-bitwise-solution-with-thinking-process-and-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0477;

public class SolutionApproach0BitManipulation2 {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int[][] store = new int[32][2];
        for (int num : nums) {
            for (int idx = 31; idx >= 0; --idx) {
                int bit = (num >> idx & 1);
                ++store[idx][bit];
                total += store[idx][bit ^ 1];
            }
        }

        return total;
    }
}