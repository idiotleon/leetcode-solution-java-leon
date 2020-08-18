/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 */
package com.zea7ot.leetcode.lvl1.lc0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1BinarySearch {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersections = new HashSet<Integer>();
        Arrays.sort(nums2);
        
        for(int num : nums1){
            if(binarySearch(nums2, num)){
                intersections.add(num);
            }
        }
        
        int idx = 0;
        int[] ans = new int[intersections.size()];
        for(int num : intersections){
            ans[idx++] = num;
        }
        
        return ans;
    }
    
    private boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}