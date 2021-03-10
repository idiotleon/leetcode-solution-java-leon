/**
 * https://leetcode.com/problems/sort-an-array/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(lg(N))
 * 
 * References:
 *  https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 */
package com.an7one.summary.sort.merge_sort;

public class MergeSortBottomUp {
    public int[] sortArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new int[0];
        mergeSort(nums);
        return nums;
    }
    
    private void mergeSort(int[] nums){
        if(nums == null || nums.length == 0) return;
        
        final int N = nums.length;
        for(int size = 1; size < N; size *= 2){
            for(int i = 0; i < N - size; i += 2 * size){
                int mid = i + size - 1;
                int end = Math.min(i + 2 * size - 1, N - 1);
                merge(i, mid, end, nums);
            }
        }
    }
    
    private void merge(int start, int mid, int end, int[] nums){
        int[] temp = new int[end - start + 1];
        int lo = start, hi = mid + 1, idx = 0;
        while(lo <= mid || hi <= end){
            if(lo > mid || hi <= end && nums[lo] > nums[hi]) temp[idx++] = nums[hi++];
            else temp[idx++] = nums[lo++];
        }
        
        System.arraycopy(temp, 0, nums, start, end - start + 1);
    }
}