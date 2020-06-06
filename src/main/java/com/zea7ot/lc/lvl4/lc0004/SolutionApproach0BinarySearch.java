/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Time Complexity: O(lg(min(L1, L2)))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=LPFhl65R7ww
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 */
package com.zea7ot.lc.lvl4.lc0004;

public class SolutionApproach0BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int L1 = nums1.length, L2 = nums2.length;
        // to make sure that the nums1 is the shorter one
        if(L1 > L2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = L1;
        while(low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = (L1 + L2 + 1) / 2 - mid1;
            
            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = (mid1 == L1) ? Integer.MAX_VALUE : nums1[mid1];
            
            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = (mid2 == L2) ? Integer.MAX_VALUE : nums2[mid2];
            
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((L1 + L2) % 2 == 0){
                    return ((double)(Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))) / 2;
                }else return Math.max(maxLeft1, maxLeft2);
            }else if(maxLeft1 > minRight2){     // too much on the left side
                high = mid1 - 1;                // to move to the left
            }else{                              // too much on the right side
                low = mid1 + 1;                 // to move to the right
            }
        }
        
        return -1;
    }
}