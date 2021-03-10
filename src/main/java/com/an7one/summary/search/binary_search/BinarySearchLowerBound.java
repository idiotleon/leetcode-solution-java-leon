package com.an7one.summary.search.binary_search;

public class BinarySearchLowerBound {
    public int getLowerBound(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(target > nums[mid]) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }

    // yet to verify
    public int getLowerBound2(int[] nums, int target){
        int lo = 0, hi = nums.length;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            if(target > nums[mid]) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}