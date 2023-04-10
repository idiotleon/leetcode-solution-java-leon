/**
 * https://leetcode.com/problems/smallest-good-base/
 * 
 * 
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/smallest-good-base/discuss/96602/JavaC-binary-search-solutions-with-detailed-explanation
 *  https://leetcode.com/problems/smallest-good-base/discuss/96589/Java-solution-with-hand-writing-explain
 */
package com.idiotleon.leetcode.lvl5.lc0483;

import java.math.BigInteger;

public class SolutionApproach0BinarySearch {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long base = Long.MAX_VALUE;
        
        for(int k = 60; k >= 2; k--){
            long lo = 2, hi = n;
            
            while(lo <= hi){
                long mid = lo + (hi - lo) / 2;
                
                BigInteger left = BigInteger.valueOf(mid);
                left = left.pow(k).subtract(BigInteger.ONE);
                
                BigInteger right = BigInteger.valueOf(n).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                
                int cmr = left.compareTo(right);
                if(cmr == 0){
                    base = Math.min(base, mid);
                    break;
                }else if(cmr < 0){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            
            // if(ans != 0) break;
        }
        
        return String.valueOf(base);
    }
}