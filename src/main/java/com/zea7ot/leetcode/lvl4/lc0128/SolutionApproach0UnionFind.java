/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 */
package com.zea7ot.leetcode.lvl4.lc0128;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0UnionFind {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(!map.containsKey(num)){   // not a duplicate
                int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
                int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
                
                int sum = left + right + 1;
                map.put(num, sum);
                
                ans = Math.max(ans, sum);
                
                // to extend the boundaries of the sequence
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        
        return ans;
    }
}