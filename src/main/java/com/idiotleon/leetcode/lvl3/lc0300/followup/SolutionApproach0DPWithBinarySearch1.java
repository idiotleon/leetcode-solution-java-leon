package com.idiotleon.leetcode.lvl3.lc0300.followup;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LC0300</a>
 * <p>
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * <p>
 * <p>
 * key steps:
 * 1. if nums[i] is smaller than the smallest tail(tails[0]), to simply update tails[0] with nums[i];
 * 2. if nums[i] is larger than the largest tail(tails[len]), to simply append it to tails(tails[++len] = nums[i]);
 * 3, if nums[i] is in the middle, to binary search the "insertion" positio (or lower bound) "idx" among tails for nums[i](num for short),
 * so that a LIS has a smaller tail, updated with nums[i]
 * <p>
 * Reference:
 * <a href="https://segmentfault.com/a/1190000003819886">Segment Fault</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DPWithBinarySearch1 {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int len = 0;
        // tails are the last actual element/digit/number of LIS of length "len".
        // As "len" increases, tails is monotonically increasing.
        final int[] tails = new int[N];
        tails[0] = nums[0];

        for (int i = 1; i < N; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]) {
                tails[++len] = nums[i];
            } else {
                tails[lowerBound(tails, 0, len, nums[i])] = nums[i];
            }
        }

        return len + 1;
    }

    private int lowerBound(int[] tails, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // this can be omitted, at the cost of a few more iterations
            // if(tails[mid] == target) return mid;
            if (target > tails[mid]) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }
}