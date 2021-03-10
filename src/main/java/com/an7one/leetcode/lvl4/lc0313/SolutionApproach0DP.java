/**
 * https://leetcode.com/problems/super-ugly-number/
 * 
 * Time Complexity:     O(N * `n`)
 *  L, length of primes(int[])
 * 
 * Space Complexity:    O(`n`) + O(N)
 * 
 * to push forward
 * 
 * References:
 *  https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained
 *  https://leetcode.com/problems/super-ugly-number/discuss/76343/108ms-easy-to-understand-java-solution/79992
 */
package com.an7one.leetcode.lvl4.lc0313;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // sanity check
        if (n <= 0 || primes == null || primes.length == 0)
            return 0;

        final int N = primes.length;
        int[] ugly = new int[n];
        int[] indexes = new int[N];
        int[] values = new int[N];
        Arrays.fill(values, 1);

        int next = 1;
        for (int i = 0; i < n; ++i) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;

            for (int j = 0; j < N; ++j) {
                // to skip any duplicate and avoid any extra multiplication
                if (values[j] == ugly[i])
                    values[j] = ugly[indexes[j]++] * primes[j];

                // to find the next ugly number
                next = Math.min(next, values[j]);
            }
        }

        return ugly[n - 1];
    }
}