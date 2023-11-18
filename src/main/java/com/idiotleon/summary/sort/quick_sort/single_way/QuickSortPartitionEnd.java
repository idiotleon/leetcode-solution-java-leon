package com.idiotleon.summary.sort.quick_sort.single_way;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <p>
 * Time Complexity:
 * O(N * lg(N)) on average
 * O(N ^ 2) in the worst case
 * <p>
 * Space Complexity:        O(1)
 * <p>
 * References:
 * <a href="https://www.baeldung.com/java-quicksort">Baeldung</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class QuickSortPartitionEnd {
    public int[] sortArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return new int[0];
        final int N = nums.length;
        quickSort(0, N - 1, nums);
        return nums;
    }

    private void quickSort(int lo, int hi, int[] nums) {
        if (lo >= hi) {
            return;
        }

        final int pivot = partition(lo, hi, nums);
        quickSort(lo, pivot - 1, nums);
        quickSort(pivot + 1, hi, nums);
    }

    /**
     * main step:
     * 1. to take the last/rightmost element as the `pivot`
     * 2. to check each element, and swap it before the `pivot` if its value is smaller
     * <p>
     * By the end of the partitioning,
     * all elements smaller than the `pivot` are on the left of it,
     * and all elements greater than the `pivot` are on the right of it.
     *
     * @param start
     * @param end
     * @param nums
     * @return
     */
    private int partition(int start, int end, int[] nums) {
        final int pivot = nums[end];
        int lo = start - 1;
        for (int hi = start; hi < end; hi++) {
            if (nums[hi] > pivot) continue;
            lo++;
            swap(lo, hi, nums);
        }

        swap(lo + 1, end, nums);
        return lo + 1;
    }

    private void swap(int i, int j, int[] nums) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}