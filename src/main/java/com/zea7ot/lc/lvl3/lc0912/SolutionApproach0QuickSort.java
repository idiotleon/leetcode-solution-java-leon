/**
 * https://leetcode.com/problems/sort-an-array/
 * 
 * Time Complexity:     O(N * lg(N)) ~ O(N ^ 2)
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.)
 */
package com.zea7ot.lc.lvl3.lc0912;

public class SolutionApproach0QuickSort {
    public int[] sortArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new int[0];
        
        final int N = nums.length;
        quickSort(0, N - 1, nums);
        
        return nums;
    }
    
    private void quickSort(int lo, int hi, int[] nums){
        if(lo >= hi) return;
        int mid = partition(lo, hi, nums);
        quickSort(lo, mid, nums);
        quickSort(mid + 1, hi, nums);
    }
    
    private int partition(int lo, int hi, int[] nums){
        int pivot = nums[lo];
        while(lo < hi){
            while(lo < hi && nums[hi] >= pivot) hi--;
            nums[lo] = nums[hi];
            while(lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}