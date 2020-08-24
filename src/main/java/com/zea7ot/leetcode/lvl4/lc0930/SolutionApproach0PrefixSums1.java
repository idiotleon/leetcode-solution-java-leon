/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc0930;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int numSubarraysWithSum(int[] nums, int S) {
        // sanity check
        if (nums == null || nums.length < S || S < 0)
            return 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        // !!!do NOT forget!!!
        prefixSums.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (sum >= S)
                count += prefixSums.getOrDefault(sum - S, 0);

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}