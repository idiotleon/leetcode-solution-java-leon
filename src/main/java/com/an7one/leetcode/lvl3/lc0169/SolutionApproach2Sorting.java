/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * the description of the problem guarantees that there always will be a majority element
 * 
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.an7one.leetcode.lvl3.lc0169;

import java.util.Arrays;

public class SolutionApproach2Sorting {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        Arrays.sort(nums);
        return nums[N / 2];
    }
}
