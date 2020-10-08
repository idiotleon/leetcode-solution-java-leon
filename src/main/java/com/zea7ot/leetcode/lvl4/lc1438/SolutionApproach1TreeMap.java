/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1438;

import java.util.TreeMap;

public class SolutionApproach1TreeMap {
    public int longestSubarray(int[] nums, int limit) {

        final int N = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int lo = 0, hi = 0;
        while (hi < N) {
            map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);

            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[lo], map.get(nums[lo]) - 1);
                if (map.get(nums[lo]) == 0) {
                    map.remove(nums[lo]);
                }

                ++lo;
            }

            ++hi;
        }

        return hi - lo;
    }
}
