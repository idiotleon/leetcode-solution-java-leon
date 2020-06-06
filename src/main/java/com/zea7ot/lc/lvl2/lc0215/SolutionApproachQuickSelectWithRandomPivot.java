/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
package com.zea7ot.lc.lvl2.lc0215;

import java.util.Random;

public class SolutionApproachQuickSelectWithRandomPivot {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k){
        if(left <= right){
            int pivot = partition(nums, left, right);
            if(pivot == k) return nums[k];
            if(pivot > k) return quickSelect(nums, left, pivot - 1, k);
            return quickSelect(nums, pivot + 1, right, k);
        }
        
        return Integer.MIN_VALUE;
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(nums, right, pivot);
        for(int j = left; j < right; j++){
            if(nums[j] > nums[right]){
                swap(nums, j, left);
                left++;
            }
        }
        swap(nums, left, right);
        return left;
    }
    
    private void swap(int[] nums, int leftIdx, int rightIdx){
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}