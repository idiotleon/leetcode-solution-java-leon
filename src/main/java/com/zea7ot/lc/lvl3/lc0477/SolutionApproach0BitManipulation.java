/**
 * https://leetcode.com/problems/total-hamming-distance/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96222/Java-Solution-with-Explanation/100721
 *  https://leetcode.com/problems/total-hamming-distance/discuss/96222/Java-Solution-with-Explanation
 */
package com.zea7ot.lc.lvl3.lc0477;

public class SolutionApproach0BitManipulation {
    public int totalHammingDistance(int[] nums) {
        final int N = nums.length;

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int ones = 0;
            for (int j = 0; j < N; ++j) {
                ones += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }

            ans += ones * (N - ones);
        }

        return ans;
    }
}