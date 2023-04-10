/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 * 
 * Time Complexity:     O(N * lg(sum))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/463222/Java-Binary-search-O(nlogk)-k-is-the-max-value-in-nums
 */
package com.idiotleon.leetcode.lvl4.lc1300;

public class SolutionApproach0BinarySearch {
    public int findBestValue(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (target >= sum)
            return max;

        int diff = target, prevValue = max;

        int lo = 0, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            sum = getSum(nums, mid);
            int curDiff = Math.abs(target - sum);
            if (curDiff < diff) {
                diff = curDiff;
                prevValue = mid;
            } else if (curDiff == diff) {
                prevValue = Math.min(prevValue, mid);
            }

            if (sum < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return prevValue;
    }

    private int getSum(int[] nums, int limit) {
        int sum = 0;
        for (int num : nums) {
            if (num > limit) {
                sum += limit;
            } else {
                sum += num;
            }
        }

        return sum;
    }
}