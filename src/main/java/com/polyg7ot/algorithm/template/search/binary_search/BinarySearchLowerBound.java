package com.polyg7ot.algorithm.template.search.binary_search;

public class BinarySearchLowerBound {
    public int getLowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    // yet to verify
    public int getLowerBound2(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(target > nums[mid]) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}