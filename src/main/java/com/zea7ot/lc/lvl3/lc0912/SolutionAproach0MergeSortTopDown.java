/**
 * https://leetcode.com/problems/sort-an-array/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(lg(N))
 * 
 * References:
 *  https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 */
package com.zea7ot.lc.lvl3.lc0912;

public class SolutionAproach0MergeSortTopDown {
    public int[] sortArray(int[] nums) {
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