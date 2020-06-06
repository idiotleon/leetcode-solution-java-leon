/**
 * https://leetcode.com/problems/count-primes/
 * 
 * Time Complexity:     O(n * lg(lg(n)))
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
 *  https://assets.leetcode.com/static_assets/public/images/solutions/Sieve_of_Eratosthenes_animation.gif
 */
package com.polyg7ot.lc.lvl1.lc0204;

public class SolutionApproach0DP1 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count++;
                for(int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        
        return count;
    }
}