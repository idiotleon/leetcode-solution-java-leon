/**
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/discuss/709227/JavaC++Python-Two-Sum/596404
 *  https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/discuss/709227/JavaC%2B%2BPython-Two-Sum
 */
package com.zea7ot.lc.lvl3.lc1498;

import java.util.Arrays;

public class SolutionApproach0TwoPointers {
    private static final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] mathPowMod = new int[N + 1];
        mathPowMod[0] = 1;
        for (int i = 1; i <= N; ++i)
            mathPowMod[i] = (mathPowMod[i - 1] * 2) % MOD;

        Arrays.sort(nums);

        int ans = 0;
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            if (nums[lo] + nums[hi] > target)
                --hi;
            else {
                ans = (ans + mathPowMod[hi - lo]) % MOD;
                ++lo;
            }
        }

        return ans;
    }
}