/**
 * @author: Leon
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
package com.polyg7ot.algorithm.template.search;

public class BinarySearch {
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // to floor the mid
            int mid = left + (right - left) / 2;

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        // to return as the unsuccessful search
        return -1;
    }

    public int binarSearchHermann(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left != right){
            // to ceil the mid
            int mid = left + (right - left) / 2 + 1;

            // no need to check whether the middle element is equal to the target
            
            if(target > nums[mid]) left = mid + 1;
            else right = mid;
        }

        // to check whether the left element is equal to the target
        if(nums[left] == target) return left;
        // to return as the unsuccessful search
        return -1;
    }

    /// where duplicates exist

    /*** 
     * if the target is in the array
     *  to return the index of the leftmost target
     *  the index of the rightmost target can be acquired as: 
     *  binarySearchLeftmost(nums, target + 1) - 1
     *  regardless of the existence of (target + 1) 
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                  eg. [5,7,7,8,8,10,10]
     *  to return the index of the next rightmost immediate smaller element if there is any,        eg. target = 9, to return 5
     *  or the length of the array                                                                  eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive             eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous rightmost immediate smaller element if there is any,    eg. target = 6, to return 3
     *  or 0    
     */
    public int binarySearchLeftmost(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(target > nums[mid]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    /**
     * if the target is in the array
     *  to return the index of the right target
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                          eg. [5,5,8,8,8,8,10,10]
     *  to return the index of the previous (rightmost - 1) immediate smaller element if there is any,      eg. target = 9, to return 5
     *  or the length of the array                                                                          eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive                     eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous (rightmost - 1) immediate smaller element if there is any,      eg. target = 6, to return 3
     *  or -1   
     */
    public int binarySearchRightmost(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(target < nums[mid]) right = mid;
            else left = mid + 1;
        }

        return right - 1;
    }
}