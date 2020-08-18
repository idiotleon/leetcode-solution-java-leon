/**
 * https://leetcode.com/problems/subsets/
 * 
 * to output all lexicographic (binary sorted) subsets
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity;    O(N * (2 ^ N))
 * 
 * References:
 *  https://leetcode.com/problems/subsets/solution/
 */
package com.zea7ot.leetcode.lvl2.lc0078.bit_masking;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return paths;

        final int N = nums.length;
        for (int i = (int) Math.pow(2, N); i < (int) Math.pow(2, N + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);

            // to append subsets corresponding to that bitmask
            List<Integer> path = new ArrayList<Integer>();
            for (int j = 0; j < N; ++j) {
                if (bitmask.charAt(j) == '1')
                    path.add(nums[j]);
            }

            // no need to copy here
            paths.add(path);
        }

        return paths;
    }
}