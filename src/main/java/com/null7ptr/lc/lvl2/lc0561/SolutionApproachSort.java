/**
 * https://leetcode.com/problems/array-partition-i/
 * 
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl2.lc0561;

import java.util.Arrays;

public class SolutionApproachSort {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        
        return sum;
    }
}