/**
 * https://leetcode.com/problems/split-array-with-equal-sum/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/split-array-with-equal-sum/discuss/101481/Simple-Java-solution-O(n2)
 */
package com.an7one.leetcode.lvl3.lc0548;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0PrefixSums {
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7)
            return false;

        final int N = nums.length;
        int[] prefixSums = new int[N];
        prefixSums[0] = nums[0];
        for (int i = 1; i < N; ++i)
            prefixSums[i] = prefixSums[i - 1] + nums[i];

        for (int j = 3; j < N - 3; ++j) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 1; i < j - 1; ++i)
                if (prefixSums[i - 1] == prefixSums[j - 1] - prefixSums[i])
                    set.add(prefixSums[i - 1]);

            for (int k = j + 2; k < N - 1; ++k)
                if (prefixSums[N - 1] - prefixSums[k] == prefixSums[k - 1] - prefixSums[j]
                        && set.contains(prefixSums[k - 1] - prefixSums[j]))
                    return true;
        }

        return false;
    }
}