/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/136750
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105623/Java-Very-Simple-without-DP
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105623/Java-Very-Simple-without-DP/337879
 * 
 * Similar Problems:
 *  2   0252    https://leetcode.com/problems/meeting-rooms/
 *  3   0253    https://leetcode.com/problems/meeting-rooms-ii/
 *  3   0435    https://leetcode.com/problems/non-overlapping-intervals/
 */
package com.zea7ot.lc.lvl4.lc0646;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int findLongestChain(int[][] pairs) {
        // sanity check
        if(pairs == null || pairs.length == 0) return 0;

        final int N = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = pairs[0][1];
        int count = 1;
        for(int i = 1; i < N; ++i){
            if(pairs[i][0] > prevEnd){
                ++count;
                prevEnd = pairs[i][1];
            }
        }
        
        return count;
    }
}