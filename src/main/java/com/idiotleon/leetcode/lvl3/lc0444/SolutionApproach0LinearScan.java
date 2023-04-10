/**
 * https://leetcode.com/problems/sequence-reconstruction/
 * 
 * Time Complexity:     O(N + TOTAL_ELEMENTS(`seqs`))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/92574/Very-short-solution-with-explanation
 */
package com.idiotleon.leetcode.lvl3.lc0444;

import java.util.List;

public class SolutionApproach0LinearScan {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // sanity check
        if (seqs == null || seqs.isEmpty())
            return false;

        final int N = org.length;
        int[] orders = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (org[i] <= 0 || org[i] > N)
                return false;

            orders[org[i]] = i;
        }

        boolean[] pairs = new boolean[N];
        for (List<Integer> seq : seqs) {
            final int SIZE = seq.size();
            for (int i = 0; i < SIZE; ++i) {
                int cur = seq.get(i);
                if (cur <= 0 || cur > N)
                    return false;

                if (i == 0 && cur == org[0])
                    pairs[0] = true;
                if (i > 0) {
                    int prev = seq.get(i - 1);
                    if (orders[prev] >= orders[cur])
                        return false;
                    if (orders[prev] + 1 == orders[cur])
                        pairs[orders[cur]] = true;
                }
            }
        }

        for (int i = 0; i < N; ++i)
            if (!pairs[i])
                return false;

        return true;
    }
}