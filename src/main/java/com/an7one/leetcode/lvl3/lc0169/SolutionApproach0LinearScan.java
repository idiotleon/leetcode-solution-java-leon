/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * the description of the problem guarantees that there always will be a majority element
 * 
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.an7one.leetcode.lvl3.lc0169;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0LinearScan {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > N / 2)
                return num;
        }

        return -1;
    }
}
