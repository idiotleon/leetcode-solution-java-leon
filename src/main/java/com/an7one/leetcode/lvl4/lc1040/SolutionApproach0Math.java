/**
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N)
 * Space Complexity:    O(1)
 * 
 *  to acquire the maximum move is to fill in all empty slots between (stones[i] ~ stones[N - 1]) or (stones[0], stones[N - 2])
 * 
 * References:
 *  https://leetcode.com/problems/moving-stones-until-consecutive-ii/discuss/286707/JavaC++Python-Sliding-Window/271997
 *  https://leetcode.com/problems/moving-stones-until-consecutive-ii/discuss/286707/JavaC%2B%2BPython-Sliding-Window
 */
package com.an7one.leetcode.lvl4.lc1040;

import java.util.Arrays;

public class SolutionApproach0Math {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        final int N = stones.length;

        int high = Math.max(stones[N - 1] - N + 2 - stones[1], stones[N - 2] - stones[0] - N + 2);
        int i = 0, low = N;
        for (int j = 0; j < N; ++j) {
            while (stones[j] - stones[i] >= N)
                ++i;

            if (j - i + 1 == N - 1 && stones[j] - stones[i] == N - 2)
                low = Math.min(low, 2);
            else
                low = Math.min(low, N - (j - i + 1));
        }

        return new int[] { low, high };
    }
}