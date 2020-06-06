/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 */
package com.zea7ot.lc.lvl1.lc0349;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                intersect.add(nums2[i]);
            }
        }
        
        int[] ans = new int[intersect.size()];
        int idx = 0;
        for(Integer num : intersect){
            ans[idx++] = num;
        }
        
        return ans;
    }
}