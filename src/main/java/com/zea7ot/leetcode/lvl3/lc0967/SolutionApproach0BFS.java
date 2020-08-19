/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(2 ^ N)
 * 
 * References:
 *  https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/211433/JavaPython-3-BFSDFS-codes-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc0967;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    public int[] numsSameConsecDiff(int N, int K) {
        // sanity check
        if (N <= 0)
            return new int[0];
        if (N == 1)
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Deque<Integer> queue = new ArrayDeque<Integer>();
        // to initialize the `queue` with all single digits
        for (int i = 0; i < 10; ++i)
            queue.add(i);

        int len = 0;
        while (true) {
            final int SIZE = queue.size();
            for (int i = 0; i < SIZE; ++i) {
                int num = queue.poll();
                if (num <= 0)
                    continue;

                int digit1 = num % 10 - K;
                int digit2 = num % 10 + K;

                if (digit1 >= 0)
                    queue.add(num * 10 + digit1);

                if (digit2 < 10 && digit2 != digit1)
                    queue.add(num * 10 + digit2);
            }

            if (++len == N - 1)
                break;
        }

        return queue.stream().mapToInt(i -> i).toArray();
    }
}