/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
 * 
 * Similar Questions:
 *  300 https://leetcode.com/problems/longest-increasing-subsequence/
 */
package com.polyg7ot.lc.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach1DPWithBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        final int L = envelopes.length;
        int[] dp = new int[L];
        int len = 0;
        
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            
            if(index < 0) index = -(index + 1);
            
            dp[index] = envelope[1];
            
            if(index == len) len++;
        }
        
        return len;
    }
}