package com.an7one.summary.search.binary_search;

public class BinarySearchRecursively {
    public int binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = left + (right - left) / 2;

            if(target == nums[mid]) return mid;

            if(target < nums[mid]) 
                return binarySearch(nums, left, mid - 1, target);

            return binarySearch(nums, mid + 1, right, target);
         }

         return -1;
    }
}