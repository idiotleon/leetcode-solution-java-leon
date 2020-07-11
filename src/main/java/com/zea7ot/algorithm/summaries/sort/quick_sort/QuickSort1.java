/**
 * Time Complexity:     
 *  O(N * lg(N)) on average
 *  O(N ^ 2) in the worst case
 * 
 * Space Complexity:        O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 */ 
package com.zea7ot.algorithm.summaries.sort.quick_sort;

public class QuickSort1 {
    public void sortArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return;
        
        final int N = nums.length;
        quickSort(0, N - 1, nums);
    }
    
    private void quickSort(int lo, int hi, int[] nums){
        if(lo >= hi) return;
        int pivot = partition(lo, hi, nums);
        quickSort(lo, pivot, nums);
        quickSort(pivot + 1, hi, nums);
    }
    
    private int partition(int lo, int hi, int[] nums){
        int pivot = nums[lo];
        while(lo < hi){
            while(lo < hi && pivot <= nums[hi]) hi--;
            nums[lo] = nums[hi];
            while(lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}