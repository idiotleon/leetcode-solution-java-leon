/**
 * https://leetcode.com/problems/ugly-number-iii/
 * 
 * Time Complexity: O(lg(Integer.MAX_VALUE))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/ugly-number-iii/discuss/387780/JavaC%2B%2B-Binary-Search-with-Venn-Diagram-Explain-Math-Formula
 */
package com.polyg7ot.lc.lvl3.lc1201;

public class SolutionApproach0BinarySearch {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(count(a, b, c, mid) < n) low = mid + 1;
            else high = mid - 1;
        }
        
        return low;
    }
    
    private int count(long a, long b, long c, long num){
        return (int) ((num / a) + (num / b) + (num / c)
            - (num / lcm(a, b))
            - (num / lcm(b, c))
            - (num / lcm(a, c))
            + (num / lcm(a, lcm(b, c))));
    }
    
    private long gcd(long a, long b){
        if(a == 0) return b;
        
        return gcd(b % a, a);
    }
    
    private long lcm(long a, long b){
        return (a * b) / gcd(a, b);
    }
}