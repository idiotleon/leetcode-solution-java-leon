/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl4.lc0287;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1OnePass {
    public int findDuplicate(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        Set<Integer> seen = new HashSet<Integer>();
        
        for(int num : nums){
            if(seen.contains(num)) return num;
            seen.add(num);
        }
        
        return -1;
    }
}