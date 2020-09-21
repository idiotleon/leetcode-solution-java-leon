/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-divisible-subset/discuss/84006/Classic-DP-solution-similar-to-LIS-O(n2)
 */
package com.zea7ot.leetcode.lvl4.lc0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DP1Dimen1 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int N = nums.length;

        int[] counts = new int[N];
        int[] pre = new int[N];
        Arrays.sort(nums);

        int max = 0, index = -1;
        for (int i = 0; i < N; i++) {
            counts[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                /**
                 * if nums[i] can be divided by nums[j], it can also be divided by every element
                 * in dp[j].
                 * 
                 * to find a previous nums[j] that has most elements
                 */
                if (nums[i] % nums[j] == 0) {
                    if (1 + counts[j] > counts[i]) {
                        counts[i] = counts[j] + 1;
                        pre[i] = j;
                    }
                }
            }

            if (counts[i] > max) {
                max = counts[i];
                index = i;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        while (index != -1) {
            ans.add(nums[index]);
            index = pre[index];
        }

        return ans;
    }
}