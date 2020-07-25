/**
 * Time Complexity: 
 *  Best:       O(N)
 *  Averagely:  O(N)
 *  Worst:      O(N ^ 2)
 */
package com.zea7ot.summaries.sort.quick_sort.single_way;

import java.util.Random;

public class QuickSelectWithRandomPivot {
    public int quickSelect(int[] nums, int left, int right, int k){
        if(left <= right){
            int pivot = partition(nums, left, right);
            if(pivot == k) return nums[k];
            else if(pivot > k) return quickSelect(nums, left, pivot - 1, k);
            else return quickSelect(nums, pivot + 1, right, k);
        }
        
        return Integer.MIN_VALUE;
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(nums, pivot, right);
        for(int i = left; i < right; i++){
            if(nums[i] > nums[right]){
                swap(nums, i, left);
                left++;
            }
        }
        swap(nums, left, right);
        return left;
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}