/**
 * pseudo code:
 *  mergeSort(nums, left, right):
 *      mid = left (right - left) / 2
 *      mergeSort(nums, left, mid)
 *      mergeSort(nums, mid + 1, right)
 *      merge(nums, left, mid, right)   # O(right - 1)
 * 
 * Time Complexity:
 *  T(N) = 2 * T(N / 2) + O(N) = O(N * lg(N))
 * 
 * Space Complexity:
 *  O(lg(N) + N)
 *      N, cost by "merge" operation, which cannot be combined with the call stacks of "mergeSort"
 * 
 * to merge sort is slower than to quick sort, because of copying arrays,
 * even though to quick sort, in the worst cases, has a worse time complexity.
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.polyg7ot.algorithm.template.sort.merge_sort;

public class MergeSort {
    
}