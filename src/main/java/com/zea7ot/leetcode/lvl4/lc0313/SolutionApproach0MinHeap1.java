/**
 * https://leetcode.com/problems/super-ugly-number/
 * 
 * Time Complexity:     O(lg(N) * `n`)
 *  L, length of primes(int[])
 * 
 * Space Complexity:    O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained
 */
package com.zea7ot.leetcode.lvl4.lc0313;

import java.util.PriorityQueue;

public class SolutionApproach0MinHeap1 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // sanity check
        if (n <= 0 || primes == null || primes.length == 0)
            return 0;

        final int N = primes.length;
        int[] ugly = new int[n];

        PriorityQueue<Num> minHeap = new PriorityQueue<Num>();
        for (int i = 0; i < N; i++) {
            minHeap.add(new Num(primes[i], 1, primes[i]));
        }

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = minHeap.peek().val;
            while (minHeap.peek().val == ugly[i]) {
                Num next = minHeap.poll();
                minHeap.add(new Num(next.prime * ugly[next.idx], next.idx + 1, next.prime));
            }
        }
        return ugly[n - 1];
    }

    private class Num implements Comparable<Num> {
        protected int val;
        protected int idx;
        protected int prime;

        protected Num(int val, int idx, int prime) {
            this.val = val;
            this.idx = idx;
            this.prime = prime;
        }

        @Override
        public int compareTo(Num that) {
            return Integer.compare(this.val, that.val);
        }
    }
}