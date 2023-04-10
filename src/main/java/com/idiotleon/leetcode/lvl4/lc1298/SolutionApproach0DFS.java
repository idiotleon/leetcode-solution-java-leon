/**
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 * 
 * Time Complexity:     O(V + E) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/discuss/769463/Java-DFS-O(n)-beat-100
 */
package com.idiotleon.leetcode.lvl4.lc1298;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    private static final int STATUS_OPEN = 1;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // sanity check, not necessary
        // if (status == null || status.length == 0)
        // return 0;

        final Set<Integer> SEEN = new HashSet<>();

        for (int box : initialBoxes) {
            dfs(box, containedBoxes, status, keys, SEEN);
        }

        int most = 0;
        for (int box : SEEN) {
            if (status[box] == STATUS_OPEN) {
                most += candies[box];
            }
        }

        return most;
    }

    private void dfs(int curBox, int[][] containedBoxes, int[] status, int[][] keys, final Set<Integer> SEEN) {
        if (!SEEN.add(curBox))
            return;

        for (int key : keys[curBox]) {
            status[key] = STATUS_OPEN;
        }

        for (int nextBox : containedBoxes[curBox]) {
            dfs(nextBox, containedBoxes, status, keys, SEEN);
        }
    }
}
