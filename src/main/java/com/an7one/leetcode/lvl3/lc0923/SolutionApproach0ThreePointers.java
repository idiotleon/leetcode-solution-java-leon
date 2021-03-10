/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity:     O(`N` * lg(`N`)) + O(`N` ^ 2) ~ O(`N` ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181128/10-lines-Super-Super-Easy-Java-Solution
 */
package com.an7one.leetcode.lvl3.lc0923;

import java.util.Arrays;

public class SolutionApproach0ThreePointers {
    private static final int MOD = (int) 1e9 + 7;

    public int threeSumMulti(int[] nums, int target) {
        final int N = nums.length;
        Arrays.sort(nums);

        int count = 0;

        for (int idx = 0; idx < N - 2; ++idx) {
            int lo = idx + 1, hi = N - 1;

            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[idx];

                if (sum < target) {
                    ++lo;
                } else if (sum > target) {
                    --hi;
                } else {
                    int dupLo = 0;
                    while (lo + dupLo < hi && nums[lo] == nums[lo + dupLo]) {
                        ++dupLo;
                    }

                    int dupHi = 0;
                    while (lo + dupLo <= hi - dupHi && nums[hi - dupHi] == nums[hi]) {
                        ++dupHi;
                    }

                    // if nums[lo, hi](both ends inclusive) all are the same,
                    // there are C(hi - lo + 1, 2) combinations,
                    // otherwise, there are (`dupLo` * `dupHi`) cases
                    count += (nums[lo] == nums[hi] ? (hi - lo + 1) * (hi - lo) / 2 : dupLo * dupHi) % MOD;
                    // cannot be skipped
                    count %= MOD;

                    lo += dupLo;
                    hi -= dupHi;
                }
            }
        }

        return count;
    }
}
