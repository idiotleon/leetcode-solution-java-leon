/**
 * https://leetcode.com/problems/additive-number/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/additive-number/discuss/75567/Java-Recursive-and-Iterative-Solutions
 *  https://leetcode.com/problems/additive-number/discuss/75567/Java-Recursive-and-Iterative-Solutions/78723
 */
package com.an7one.leetcode.lvl4.lc0306;

public class SolutionApproach0BrutalForce {
    public boolean isAdditiveNumber(String num) {
        final int L = num.length();
        for(int i = 1; i <= L / 2; i++){
            for(int j = 1; Math.max(j, i) <= L - i - j; ++j){
                if(isValid(i, j, num)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(int i, int j, String num){
        if(num.charAt(0) == '0' && i > 1) return false;
        if(num.charAt(i) == '0' && j > 1) return false;
        
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        
        for(int start = i + j; start != num.length(); start += sum.length()){
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if(!num.startsWith(sum, start)) return false;
        }
        
        return true;
    }
}