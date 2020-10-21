/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 * 
 * Time Complexity:     O(`N` * `RANGE`)
 * Space Complexity:    O(`RANGE` * 2) ~ O(`RANGE`)
 * 
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181125/Knapsack-O(n-*-target)-or-Straightforward-O(n2)/257611
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181125/Knapsack-O(n-*-target)-or-Straightforward-O(n2)
 */
package com.zea7ot.leetcode.lvl3.lc0923;

public class SolutionApproach0Knapsack {
    private static final int MOD = (int) 1e9 + 7;
    private static final int RANGE = 300 + 1;

    public int threeSumMulti(int[] nums, int target) {
        // not used
        // final int N = nums.length;
        int count = 0;

        // since it is about 3 sum,
        // this dp(IntArray) is used to keep track of the first two integer and their
        // sums.
        int[][] dp = new int[RANGE][2];

        for (int num : nums) {
            // when `num` is considered as the third number
            if (target >= num)
                count += dp[target - num][1] % MOD;
            count %= MOD;

            // when `num` is considered as the first number, to try to find the "twoSum":
            // to seek `twoSum` in the range of possible two sums,
            // by adding the current `num` to the corresponding previous "oneSum"
            for (int twoSum = target; twoSum >= num; --twoSum) {
                dp[twoSum][1] += dp[twoSum - num][0];
            }

            // when `num` is considered as the first number, to try to find the "oneSum"
            ++dp[num][0];
        }

        return count;
    }
}
