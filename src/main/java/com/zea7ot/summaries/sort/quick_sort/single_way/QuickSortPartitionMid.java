/**
 * pseudo code:
 *  quickSort(nums, lo, hi)
 *      pivot = partition(nums, lo, hi) #O(hi - 1)
 *      quickSort(nums, lo, pivot)
 *      quickSort(nums, pivot + 1, hi)
 * 
 * Time Complexity:
 * Best case:
 *  T(N) = 2 * T(N / 2) + O(N) = O(N * lg(N))
 * 
 * Worst case:
 *  the pivot always lands at the beginning of the array, e.g. [1,2,3,4,5,6,7]
 *  T(N) = T(N - 1) + T(1) + O(N) = O(N ^ 2)
 * 
 * Non-worst case:
 *  T(N) = T(N / 10) + T(9 * N / 10) + O(N) = O(N * lg(N))
 * 
 * 
 * Space Complexity:
 *  Best/Average: 
 *      O(lg(N))
 * 
 *  Worst case:
 *      O(N)
 * 
 * 
 * References:
 *  https://www.programcreek.com/2012/11/quicksort-array-in-java/
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */ 
package com.zea7ot.summaries.sort.quick_sort.single_way;

public class QuickSortPartitionMid {
    public int[] sortArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new int[0];
        
        final int N = nums.length;
        quickSort(0, N - 1, nums);
        return nums;
    }
    
    /**
     * to parition in the middle
     * 
     * @param start
     * @param end
     * @param nums
     */
    private void quickSort(int start, int end, int[] nums){
        if(start >= end) return;
        
        int lo = start, hi = end;
        int mid = lo + (hi - lo) / 2;
        int pivot = nums[mid];
        
        while(lo <= hi){
            while(nums[lo] < pivot) lo++;
            while(pivot < nums[hi]) hi--;
            if(lo <= hi) swap(lo++, hi--, nums);
        }
        
        if(start < hi) quickSort(start, hi, nums);
        if(lo < end) quickSort(lo, end, nums);
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}