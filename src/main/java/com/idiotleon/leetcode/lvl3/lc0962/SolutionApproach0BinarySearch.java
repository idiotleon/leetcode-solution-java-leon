/**
 * https://leetcode.com/problems/maximum-width-ramp/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 */
package com.idiotleon.leetcode.lvl3.lc0962;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BinarySearch {
    public int maxWidthRamp(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int widest = 0;

        List<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < N; ++i) {
            if (stack.isEmpty() || nums[i] < nums[stack.get(stack.size() - 1)]) {
                stack.add(i);
            } else {
                int lo = 0, hi = stack.size();
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[stack.get(mid)] > nums[i])
                        lo = mid + 1;
                    else
                        hi = mid;
                }

                widest = Math.max(widest, i - stack.get(lo));
            }
        }

        return widest;
    }
}