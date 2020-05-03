package com.null7ptr.algorithm.sort.quick_sort;

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