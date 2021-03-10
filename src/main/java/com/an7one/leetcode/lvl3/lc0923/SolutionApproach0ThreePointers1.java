/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 * 
 * Time Complexity:     O(`N` + (`RANGE` ^ 2))
 * Space Complexity:    O(`RANGE`)
 * 
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181131/C%2B%2BJavaPython-O(N-%2B-101-*-101)
 */
package com.an7one.leetcode.lvl3.lc0923;

public class SolutionApproach0ThreePointers1 {
    private static final int MOD = (int) 1e9 + 7;
    private static final int RANGE = 100 + 1;

    public int threeSumMulti(int[] nums, int target) {
        // not used
        /// final int N = nums.length;

        long[] counts = new long[RANGE];

        for (int num : nums) {
            ++counts[num];
        }

        int count = 0;

        for (int i = 0; i < RANGE; ++i) {
            for (int j = i; j < RANGE; ++j) {
                int k = target - i - j;
                if (k > 100 || k < 0)
                    continue;

                if (i == j && j == k) {
                    count += (counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6) % MOD;
                } else if (i == j && j != k) {
                    count += (counts[i] * (counts[i] - 1) / 2 * counts[k]) % MOD;
                } else if (j < k) {
                    count += (counts[i] * counts[j] * counts[k]) % MOD;
                }
            }
        }

        return count;
    }
}
