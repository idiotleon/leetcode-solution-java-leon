/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution/168353
 *  https://leetcode.com/problems/range-sum-query-immutable/discuss/75194/Explanation-with-Images
 */
package com.zea7ot.leetcode.lvl2.lc0303;

public class SolutionApproach0PrefixSums {
    private int[] prefixSums;

    public SolutionApproach0PrefixSums(int[] nums) {
        final int N = nums.length;
        this.prefixSums = new int[N + 1];
        for (int i = 0; i < N; ++i)
            prefixSums[i + 1] = prefixSums[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return prefixSums[j + 1] - prefixSums[i];
    }
}