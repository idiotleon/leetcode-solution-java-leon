/**
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 */
package com.zea7ot.leetcode.lvl3.lc0137;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public int singleNumber(int[] nums) {
        // not used
        // final int N = nums.length;

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}