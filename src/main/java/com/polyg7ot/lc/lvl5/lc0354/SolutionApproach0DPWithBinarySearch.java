/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(1)
 * 
 * References:  
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87015
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87032
 * 
 * Similar Problems:
 *  300 https://leetcode.com/problems/longest-increasing-subsequence/
 */
package com.polyg7ot.lc.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach0DPWithBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        // sanity check
        if(envelopes == null || envelopes.length == 0 || envelopes.length < 2) return 0;

        // to sort:
        //  1. increasing width
        //  2. with 1 satisified, decreasing height
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        final int L = envelopes.length;
        int[] dp = new int[L];
        int size = 0;
        
        for(int[] envelope : envelopes){
            int left = 0, right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] < envelope[1]) left = mid + 1;
                else right = mid;
            }
            
            dp[left] = envelope[1];
            
            if(left == size) size++;
        }
        
        return size;
    }
}