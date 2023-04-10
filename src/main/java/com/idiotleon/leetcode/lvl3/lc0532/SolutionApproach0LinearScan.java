/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * 
 * Time  Complexity:    O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl3.lc0532;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0LinearScan {
    public int findPairs(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        
        for(int num : nums){
            if(set.contains(num))
                ans.add(num);
            
            set.add(num + k);
        }
        
        return ans.size();
    }
}
