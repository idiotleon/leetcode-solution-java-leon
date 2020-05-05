/**
 * https://leetcode.com/problems/count-primes/
 */
package com.polyg7ot.lc.lvl1.lc0204;

public class Solution {
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