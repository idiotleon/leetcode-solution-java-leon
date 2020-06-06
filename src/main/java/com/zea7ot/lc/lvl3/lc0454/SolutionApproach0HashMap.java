/**
 * https://leetcode.com/problems/4sum-ii/
 *  
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)/98228
 */
package com.zea7ot.lc.lvl3.lc0454;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int a : A){
            for(int b : B){
                int sum = a + b;
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            }
        }
        
        int ans = 0;
        for(int c : C){
            for(int d : D){
                int sum = -c - d;
                ans += counts.getOrDefault(sum, 0);
            }
        }
        
        return ans;
    }
}