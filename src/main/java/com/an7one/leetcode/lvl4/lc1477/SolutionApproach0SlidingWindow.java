/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * such an approach only applies when numbers are positive, which was guaranteed in this problem
 * 
 * References:
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *  https://zxi.mytechroad.com/blog/sliding-window/leetcode-1477-find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */
package com.an7one.leetcode.lvl4.lc1477;

import java.util.Arrays;

public class SolutionApproach0SlidingWindow {
    public int minSumOfLengths(int[] nums, int target) { // nums = [3,2,2,4,3], target = 3
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] minLens = new int[N];
        Arrays.fill(minLens, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int s = 0;
        int minLen = Integer.MAX_VALUE;

        for (int e = 0; e < N; e++) { // nums = [3,2,2,4,3], target = 3
            sum += nums[e]; // (e = 0, sum = 3); (e = 1, sum = 5); (e = 2, sum = 4); (e = 3, sum = 6); (e =
                            // 4, sum = 3)
            while (sum > target)
                sum -= nums[s++]; // (s = 0, sum = 3); (s = 1, sum = 2); (s = 2, sum = 2); (s = 3, sum = 4), (s =
                                  // 4, sum = 0); (s = 4, sum = 2)

            if (sum == target) { // true; false; false; false; true
                int curLen = e - s + 1; // 1; ; ; ; ; 1

                // to guarantee that there are at least two subarrays
                if (s > 0 && minLens[s - 1] != Integer.MAX_VALUE) { // false; _; _; _; _; true
                    ans = Math.min(ans, curLen + minLens[s - 1]);
                }

                minLen = Math.min(minLen, curLen); // minLen = 1; ; ; ; ; minLen = 1
            }

            minLens[e] = minLen; // minLens[0] = 1; minLen[1] = 1; minLen[2] = 1; minLen[2] = 1; minLen[3] = 1;
                                 // minLen[4] = 1
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}