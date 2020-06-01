/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:  
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87015
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation/87032
 * 
 * Similar Problems:
 *  3   300     https://leetcode.com/problems/longest-increasing-subsequence/
 */
package com.polyg7ot.lc.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach0DPWithBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        // sanity check
        if(envelopes == null || envelopes.length == 0 || envelopes.length < 2) return 0;

        // to sort:
        //  1. with width increasing
        //  2. with 1 satisified, with height decreasing
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        final int L = envelopes.length;
        int[] dp = new int[L];
        int size = 0;
        
        for(int[] envelope : envelopes){
            int lo = 0, hi = size;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(dp[mid] < envelope[1]) lo = mid + 1;
                else hi = mid;
            }
            
            dp[lo] = envelope[1];
            
            if(lo == size) size++;
        }
        
        return size;
    }
}