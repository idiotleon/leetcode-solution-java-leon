/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 */
package com.polyg7ot.lc.lvl1.lc0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproahc1TwoPtrs {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersections = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                intersections.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] ans = new int[intersections.size()];
        int idx = 0;
        for(int num : intersections){
            ans[idx++] = num;
        }
        
        return ans;
    }
}