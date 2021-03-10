/**
 * https://leetcode.com/problems/single-number/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0136;

public class SolutionApproach0LinearScan {
    public int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single ^= num;
        }

        return single;
    }
}