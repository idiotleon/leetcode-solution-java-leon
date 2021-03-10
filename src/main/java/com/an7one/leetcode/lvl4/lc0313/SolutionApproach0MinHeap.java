/**
 * https://leetcode.com/problems/super-ugly-number/
 * 
 * Time Complexity:     O(lg(N) * `n`)
 *  L, length of primes(int[])
 * 
 * Space Compleixty:    O(`n`)
 * 
 * Reference:
 *  https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained/79857
 *  https://leetcode.com/problems/super-ugly-number/discuss/277313/My-view-of-this-question-hope-it-can-help-you-understand
 */
package com.an7one.leetcode.lvl4.lc0313;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0MinHeap {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // sanity check
        if (n <= 0 || primes == null || primes.length == 0)
            return 0;

        final int N = primes.length;
        Set<Integer> uglySet = new HashSet<Integer>();
        Queue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            minHeap.offer(new int[] { primes[i], primes[i], 0 });
            uglySet.add(primes[i]);
        }

        int[] ugly = new int[n + 1];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int[] min = minHeap.poll();
            int num = min[0];
            ugly[i] = num;
            int prime = min[1];
            int idx = min[2] + 1;
            int newNum = prime * ugly[idx];
            // to remove any duplicate
            while (uglySet.contains(newNum)) {
                newNum = prime * ugly[++idx];
            }

            minHeap.offer(new int[] { newNum, prime, idx });
            uglySet.add(newNum);
        }

        return ugly[n - 1];
    }
}