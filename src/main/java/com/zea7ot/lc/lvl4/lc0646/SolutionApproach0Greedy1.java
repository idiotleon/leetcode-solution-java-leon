/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105610/Java-O(nlog(n))-Time-O(1)-Space/108174
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105610/Java-O(nlog(n))-Time-O(1)-Space/108171
 * 
 * Similar Problems:
 *  2   0252    https://leetcode.com/problems/meeting-rooms/
 *  3   0253    https://leetcode.com/problems/meeting-rooms-ii/
 *  3   0435    https://leetcode.com/problems/non-overlapping-intervals/
 */
package com.zea7ot.lc.lvl4.lc0646;

import java.util.Arrays;

public class SolutionApproach0Greedy1 {
    public int findLongestChain(int[][] pairs) {
        // sanity check
        if(pairs == null || pairs.length < 2) return 0;
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for(int[] pair : pairs){
            if(pair[0] > end){
                count++;
                end = pair[1];
            }
        }
        
        return count;
    }
}