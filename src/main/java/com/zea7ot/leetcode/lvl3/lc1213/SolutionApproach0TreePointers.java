/**
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 * 
 * Time Complexity:     O(min(L1, L2, L3))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc1213;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TreePointers {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        final int L1 = arr1.length, L2 = arr2.length, L3 = arr3.length;
        List<Integer> ans = new ArrayList<Integer>();
        int idx1 = 0, idx2 = 0, idx3 = 0;
        while(idx1 < L1 && idx2 < L2 && idx3 < L3){
            int min = Math.min(arr1[idx1], Math.min(arr2[idx2], arr3[idx3]));
            
            if(arr1[idx1] == arr2[idx2] && arr1[idx1] == arr3[idx3])
                ans.add(arr1[idx1]);
            
            if(arr1[idx1] == min) ++idx1;
            if(arr2[idx2] == min) ++idx2;
            if(arr3[idx3] == min) ++idx3;
        }
        
        return ans;
    }
}