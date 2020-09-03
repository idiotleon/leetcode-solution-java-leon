/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(k)
 * 
 * References:
 *  https://leetcode.com/problems/contains-duplicate-iii/discuss/824879/Java-2-Solutions-or-Brute-Force-O(n2)-or-TreeSet-O(nLogk)
 */
package com.zea7ot.leetcode.lvl4.lc0220;

import java.util.TreeSet;

public class Solution0ApproachTreeSet {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // sanity check
        if (nums == null || nums.length == 0 || k <= 0)
            return false;

        final int N = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < N; ++i) {
            Long floor = set.floor(1L * nums[i] + t);
            Long ceil = set.ceiling(1L * nums[i] - t);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;

            set.add(1L * nums[i]);

            if (i >= k)
                set.remove(1L * nums[i - k]);
        }

        return false;
    }
}
