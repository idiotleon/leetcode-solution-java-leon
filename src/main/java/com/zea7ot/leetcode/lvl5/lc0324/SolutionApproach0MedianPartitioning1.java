/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/wiggle-sort-ii/discuss/77684/summary-of-the-various-solutions-to-wiggle-sort-for-your-reference/81858
 */
package com.zea7ot.leetcode.lvl5.lc0324;

import java.util.Random;

public class SolutionApproach0MedianPartitioning1 {
    public void wiggleSort(int[] nums) {
        final int N = nums.length;
        int mid = (N + 1) >> 1;
        int[] cloned = nums.clone();
        int median = kthSmallestNumber(mid, nums);

        int i = 0, j = 0, k = N - 1;
        while (j <= k) {
            if (cloned[j] < median)
                swap(i++, j++, cloned);
            else if (cloned[j] > median)
                swap(j, k--, cloned);
            else
                ++j;
        }

        i = mid - 1;
        j = 0;
        while (i >= 0) {
            nums[j] = cloned[i];
            --i;
            j += 2;
        }

        i = N - 1;
        j = 1;
        while (i >= mid) {
            nums[j] = cloned[i];
            --i;
            j += 2;
        }
    }

    // quick select
    private int kthSmallestNumber(int k, int[] nums) {
        Random random = new Random();

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(i, random.nextInt(i + 1), nums);
        }

        int l = 0, r = nums.length - 1;
        k--;

        while (l < r) {
            int m = getMiddle(l, r, nums);

            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int getMiddle(int lo, int hi, int[] nums) {
        int i = lo;

        for (int j = lo + 1; j <= hi; ++j)
            if (nums[j] < nums[lo])
                swap(++i, j, nums);

        swap(lo, i, nums);
        return i;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}