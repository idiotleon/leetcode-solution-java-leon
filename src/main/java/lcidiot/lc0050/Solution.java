/**
 * https://leetcode.com/problems/powx-n/
 */

package main.java.lcidiot.lc0050;

class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE && x > 1) return 0;
        
        if(n == 0) return 1;
        
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}