/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105610/Java-O(nlog(n))-Time-O(1)-Space/108174
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105610/Java-O(nlog(n))-Time-O(1)-Space/108171
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/225801/Proof-of-the-greedy-solution
 */
package com.idiotleon.leetcode.lvl4.lc0646;

import java.util.Arrays;

public class SolutionApproach0Greedy1 {
    public int findLongestChain(int[][] pairs) {
        // sanity check
        if (pairs == null || pairs.length < 2)
            return 0;

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }

        return count;
    }
}