package com.an7one.leetcode.lvl4.lc0446;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 * <p>
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * <p>
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/discuss/92822/Detailed-explanation-for-Java-O(n2)-solution
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP {
    public int numberOfArithmeticSlices(int[] nums) {
        final int L = nums.length;
        List<Map<Integer, Integer>> arithmeticCounts = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            arithmeticCounts.add(new HashMap<>());
        }

        int count = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;

                int d = (int) diff;
                int c1 = arithmeticCounts.get(i).getOrDefault(d, 0);
                int c2 = arithmeticCounts.get(j).getOrDefault(d, 0);
                count += c2;

                arithmeticCounts.get(i).put(d, c1 + c2 + 1);
            }
        }

        return count;
    }
}