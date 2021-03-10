/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 * 
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * 
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/discuss/92822/Detailed-explanation-for-Java-O(n2)-solution
 */
package com.an7one.leetcode.lvl4.lc0446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproachDP {
    public int numberOfArithmeticSlices(int[] nums) {
        final int L = nums.length;
        List<Map<Integer, Integer>> arithmeticCounts = new ArrayList<Map<Integer, Integer>>();
        for(int i = 0; i < L; i++){
            arithmeticCounts.add(new HashMap<Integer, Integer>());
        }
        
        int count = 0;
        for(int i = 0; i < L; i++){
            for(int j = 0; j < i; j++){
                long diff = (long)nums[i] - nums[j];
                if(diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                
                int d = (int)diff;
                int c1 = arithmeticCounts.get(i).getOrDefault(d, 0);
                int c2 = arithmeticCounts.get(j).getOrDefault(d, 0);
                count += c2;
                
                arithmeticCounts.get(i).put(d, c1 + c2 + 1);
            }
        }
        
        return count;
    }
}