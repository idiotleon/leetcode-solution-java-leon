/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 */
package com.idiotleon.leetcode.lvl4.lc1438;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoDeque {
    public int longestSubarray(int[] nums, int limit) {
        final int N = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int lo = 0, hi = 0;
        while (hi < N) {
            while (!maxDeque.isEmpty() && nums[hi] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }

            while (!minDeque.isEmpty() && nums[hi] < minDeque.peekLast()) {
                minDeque.pollLast();
            }

            maxDeque.add(nums[hi]);
            minDeque.add(nums[hi]);

            if (maxDeque.peek() - minDeque.peek() > limit) {
                if (maxDeque.peek() == nums[lo])
                    maxDeque.poll();
                if (minDeque.peek() == nums[lo])
                    minDeque.poll();

                ++lo;
            }

            ++hi;
        }

        return hi - lo;
    }
}
