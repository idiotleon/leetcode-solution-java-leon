/**
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 */
package com.an7one.leetcode.lvl3.lc0137;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0HashSet {
    public int singleNumber(int[] nums) {
        // not used
        // final int N = nums.length;

        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int num : nums) {
            sumArray += num;
            set.add((long) num);
        }

        for (Long s : set)
            sumSet += s;

        return (int) ((3 * sumSet - sumArray) / 2);
    }
}