/**
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 * 
 * either `(i & (1 << j)) != 0` or `(i & (1 << j)) == 0`, but the actual paths are different
 * 
 * References:
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation/26405
 *  https://www.mathsisfun.com/sets/power-set.html
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation
 */
package com.an7one.leetcode.lvl2.lc0078.bit_masking;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> PATHS = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return PATHS;

        final int N = nums.length;
        // not necessary
        // Arrays.sort(nums);
        final int TOTAL_NUM = 1 << N;
        for (int i = 0; i < TOTAL_NUM; ++i) {
            final List<Integer> PATH = new ArrayList<>();

            for (int j = 0; j < N; ++j) {
                if ((i & (1 << j)) != 0) {
                    PATH.add(nums[j]);
                }
            }

            PATHS.add(PATH);
        }

        return PATHS;
    }
}