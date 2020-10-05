/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * `dp[i]`, the length of the longest divisible subset ending with nums[i]
 * 
 * References:
 *  https://leetcode.com/problems/largest-divisible-subset/discuss/83999/Easy-understood-Java-DP-solution-in-28ms-with-O(n2)-time
 *  https://youtu.be/FLbqgyJ-70I?t=3068
 */
package com.zea7ot.leetcode.lvl4.lc0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DP1Dimen { // [2,3,4,9,8]
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        // to find the length of largest subset it has
        for (int hi = 1; hi < N; ++hi) {
            for (int lo = hi - 1; lo >= 0; --lo) {
                if (nums[hi] % nums[lo] == 0) {
                    dp[hi] = Math.max(dp[hi], dp[lo] + 1);
                }
            }
        }

        // to get the index of the element as the tail of the longest divisible subset
        int idxMaxLen = 0;
        for (int i = 1; i < N; ++i) {
            idxMaxLen = dp[i] > dp[idxMaxLen] ? i : idxMaxLen;
        }
        // equivalently
        // for(int i = 1; i < N; i++){
        // if(dp[i] > dp[idxMaxLen]){
        // idxMaxLen = i;
        // }
        // }

        // from nums[idxMaxLen] to 0,
        // to add every element which belongs to the largest subset
        int maxLenTail = nums[idxMaxLen], curMaxLen = dp[idxMaxLen];
        for (int i = idxMaxLen; i >= 0; --i) {
            if (maxLenTail % nums[i] == 0 && dp[i] == curMaxLen) {
                ans.add(nums[i]);
                maxLenTail = nums[i];
                --curMaxLen;
            }
        }

        return ans;
    }
}