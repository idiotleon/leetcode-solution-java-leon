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

public class SolutionApproach0DP1 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // sanity check
        if (n <= 0 || primes == null || primes.length == 0)
            return 0;

        final int N = primes.length;
        int[] ugly = new int[n];
        int[] indexes = new int[N];

        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            // to find the next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; ++j) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[indexes[j]]);
            }

            // to skip any duplicate
            for (int j = 0; j < N; ++j) {
                while (primes[j] * ugly[indexes[j]] <= ugly[i]) {
                    ++indexes[j];
                }
            }
        }

        return ugly[n - 1];
    }
}