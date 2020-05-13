/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Time Complexity: O(lg(min(L1, L2)))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
 */
package com.polyg7ot.lc.lvl4.lc0004;

public class SolutionApproach1BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int L1 = nums1.length, L2 = nums2.length;
        // to make sure that nums1 is longer than nums2
        if(L1 < L2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = 2 * L2;
        while(low <= high){
            // to try to cur nums2
            int mid2 = low + (high - low) / 2;
            // to calculate mid1 accordingly
            int mid1 = L1 + L2 - mid2;
            
            // to get left1, left2, right1, right2 respectively
            double left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double right1 = (mid1 == L1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double right2 = (mid2 == L2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            // lower half of nums1 is too big
            if(left1 > right2) low = mid2 + 1;
            // lower half of nums2 is too big
            else if(left2 > right1) high = mid2 - 1;
            else return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
        }
        
        return -1;
    }
}