/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41130/Another-accepted-Java-O(n)-solution
 */
package com.idiotleon.leetcode.lvl4.lc0128;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public int longestConsecutive(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int longest = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        for (int num : nums) {
            int len = 1;

            int lo = num;
            while (set.contains(--lo)) {
                ++len;
                set.remove(lo);
            }

            int hi = num;
            while (set.contains(++hi)) {
                ++len;
                set.remove(hi);
            }

            longest = Math.max(longest, len);
        }

        return longest;
    }
}