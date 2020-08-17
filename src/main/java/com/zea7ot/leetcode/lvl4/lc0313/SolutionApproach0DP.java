/**
 * https://leetcode.com/problems/super-ugly-number/
 * 
 * Time Complexity:     O(L * n)
 *  L, length of primes(int[])
 * 
 * Space Complexity:    O(n) + O(L)
 * 
 * to push forward
 * 
 * References:
 *  https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained
 *  https://leetcode.com/problems/super-ugly-number/discuss/76343/108ms-easy-to-understand-java-solution/79992
 */
package com.zea7ot.leetcode.lvl4.lc0313;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // sanity check
        if(n <= 0 || primes == null || primes.length == 0) return 0;

        final int L = primes.length;
        int[] ugly = new int[n];
        int[] idx = new int[L];
        int[] val = new int[L];
        Arrays.fill(val, 1);
        
        int next = 1;
        for(int i = 0; i < n; i++){
            ugly[i] = next;
            next = Integer.MAX_VALUE;

            for(int j = 0; j < L; j++){
                // to skip any duplicate and avoid any extra multiplication
                if(val[j] == ugly[i]){
                    val[j] = ugly[idx[j]++] * primes[j];
                }
                
                // to find the next ugly number
                next = Math.min(next, val[j]);
            }
        }
        
        return ugly[n - 1];
    }
}