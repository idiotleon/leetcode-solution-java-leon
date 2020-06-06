/**
 * https://leetcode.com/problems/4sum-ii/
 * 
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/4sum-ii/disacuss/93920/Clean-java-solution-O(n2)
 */
package com.zea7ot.lc.lvl3.lc0454;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1HashMap {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                ans += counts.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }
        
        return ans;
    }
}