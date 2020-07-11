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
 *  https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.algorithm.summaries.sort.merge_sort;

public class MergeSortTopDown {
    public int[] sortArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new int[0];
        final int N = nums.length;
        mergeSort(0, N - 1, nums);
        return nums;
    }
    
    private void mergeSort(int start, int end, int[] nums){
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums);
        mergeSort(mid + 1, end, nums);
        merge(start, end, nums);
    }
    
    private void merge(int start, int end, int[] nums){
        int mid = start + (end - start) / 2;
        int[] temp = new int[end - start + 1];
        int lo = start, hi = mid + 1, idx = 0;
        while(lo <= mid || hi <= end){
            if(lo > mid || hi <= end && nums[lo] > nums[hi]) temp[idx++] = nums[hi++];
            else temp[idx++] = nums[lo++];            
        }
        
        System.arraycopy(temp, 0, nums, start, end - start + 1);
    }
}