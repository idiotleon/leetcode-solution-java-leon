/**
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
package com.idiotleon.leetcode.lvl2.lc0985;

public class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int[] result = new int[N];
        int index = 0, evenSum = 0;

        // to get the initial evenSum
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        // to calculate evenSum per query
        for (int[] query : queries) {
            // to substract the value if it was even
            if (nums[query[1]] % 2 == 0) {
                evenSum -= nums[query[1]];
            }

            // to execute the query
            nums[query[1]] += query[0];

            // to add the value if it is even now
            if (nums[query[1]] % 2 == 0) {
                evenSum += nums[query[1]];
            }

            result[index++] = evenSum;
        }

        return result;
    }
}