/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl4.lc0287;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1OnePass {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Set<Integer> visited = new HashSet<Integer>();
        
        for(int num : nums){
            if(visited.contains(num)) return num;
            visited.add(num);
        }
        
        return -1;
    }
}