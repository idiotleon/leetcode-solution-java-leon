/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41130/Another-accepted-Java-O(n)-solution
 */
package com.an7one.leetcode.lvl4.lc0128;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set1 {
    public int longestConsecutive(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int longest = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);

        for (int i = 0; i < N; ++i) {
            int count = 1;

            // to look left
            int num = nums[i];
            while (set.contains(--num)) {
                ++count;
                set.remove(num);
            }

            // to look right
            num = nums[i];
            while (set.contains(++num)) {
                ++count;
                set.remove(num);
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}