/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/39096
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 */
package com.zea7ot.leetcode.lvl4.lc0128;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0UnionFind {
    public int longestConsecutive(int[] nums) {
        // santiy check
        if (nums == null || nums.length == 0)
            return 0;

        int longest = 0;
        Map<Integer, Integer> ranges = new HashMap<>();
        for (int num : nums) {
            if (ranges.containsKey(num))
                continue;

            // not a duplicate
            int left = ranges.getOrDefault(num - 1, 0);
            int right = ranges.getOrDefault(num + 1, 0);

            final int LEN = left + right + 1;
            ranges.put(num, LEN);

            longest = Math.max(longest, LEN);

            // to extend the boundaries of the sequence
            if (left > 0)
                ranges.put(num - left, LEN);
            if (right > 0)
                ranges.put(num + right, LEN);
        }

        return longest;
    }
}