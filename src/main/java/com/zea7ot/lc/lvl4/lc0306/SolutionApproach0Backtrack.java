/**
 * https://leetcode.com/problems/additive-number/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * "isValid()" is a tail recursion, which can be easily turned into a iterative loop
 * 
 * References:
 *  https://leetcode.com/problems/additive-number/discuss/75567/Java-Recursive-and-Iterative-Solutions
 */
package com.zea7ot.lc.lvl4.lc0306;

import java.math.BigInteger;

public class SolutionApproach0Backtrack {
    public boolean isAdditiveNumber(String num) {
        final int L = num.length();
        for(int i = 1; i <= L / 2; i++){
            if(num.charAt(0) == '0' && i > 1) return false;
            
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for(int j = 1; Math.max(j, i) <= L - i - j; ++j){
                if(num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if(isValid(x1, x2, j + i, num)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num){
        if(start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}