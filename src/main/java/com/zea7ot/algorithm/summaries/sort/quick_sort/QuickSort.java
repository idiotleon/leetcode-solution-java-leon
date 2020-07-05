/**
 * pseudo code:
 *  quickSort(nums, left, right)
 *      pivot = partition(nums, left, right) #O(right - 1)
 *      quickSort(nums, left, pivot)
 *      quickSort(nums, pivot + 1, right)
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
 * 
 * Space Complexity:
 *  Best/Average: 
 *      O(lg(N))
 * 
 *  Worst case:
 *      O(N)
 * 
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 */
package com.zea7ot.algorithm.summary.sort.quick_sort;

public class QuickSort {
    public void quickSort(int[] nums, int start, int end){
        if(start <= end) return;

        int left = start, right = end;
        int pivot = left + (right - left) / 2;

        // quick sort
        while(left <= right){
            while(nums[left] < nums[pivot]) left++;
            while(nums[right] > nums[pivot]) right--;
            swap(nums, left, right);
            left++;
            right--;
        }

        // selection
        if(left < end) quickSort(nums, left, end);
        if(right > start) quickSort(nums, start, right);
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}