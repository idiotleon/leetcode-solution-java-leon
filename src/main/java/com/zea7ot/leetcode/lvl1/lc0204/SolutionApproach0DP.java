/**
 * https://leetcode.com/problems/count-primes/
 * 
 * Time Complexity:     O(n * lg(lg(n)))
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/count-primes/discuss/57593/12-ms-Java-solution-modified-from-the-hint-method-beats-99.95
 */
package com.zea7ot.leetcode.lvl1.lc0204;

public class SolutionApproach0DP {
    public int countPrimes(int n) {
        // sanity check
        if(n < 3) return 0;
        
        boolean[] notPrime = new boolean[n];
        
        int count = n / 2;
        for(int i = 3; i * i < n; i += 2){
            if(notPrime[i]) continue;
            
            for(int j = i * i; j < n; j += 2 * i){
                if(!notPrime[j]){
                    --count;
                    notPrime[j] = true;
                }
            }
        }
        
        return count;
    }
}