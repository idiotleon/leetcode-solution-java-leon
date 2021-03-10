/**
 * https://leetcode.com/problems/teemo-attacking/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/teemo-attacking/discuss/97465/O(n)-Java-Solution-using-same-idea-of-merge-intervals/101999
 */
package com.an7one.leetcode.lvl2.lc0495;

public class SolutionApproach0Greedy {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // sanity check
        if (timeSeries == null || timeSeries.length == 0 || duration == 0)
            return 0;

        final int N = timeSeries.length;
        int poisoned = duration;
        for (int i = 1; i < N; ++i) {
            poisoned += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }

        return poisoned;
    }
}
