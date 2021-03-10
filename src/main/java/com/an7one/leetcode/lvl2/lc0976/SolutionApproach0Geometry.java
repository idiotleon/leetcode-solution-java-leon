/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/largest-perimeter-triangle/discuss/217988/JavaC%2B%2BPython-Sort-and-Try-Biggest
 */
package com.an7one.leetcode.lvl2.lc0976;

import java.util.Arrays;

public class SolutionApproach0Geometry {
    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        final int N = nums.length;

        Arrays.sort(nums);
        for (int i = N - 1; i > 1; --i) {
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }

        return 0;
    }
}