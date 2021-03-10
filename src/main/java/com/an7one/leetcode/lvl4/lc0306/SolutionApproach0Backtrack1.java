/**
 * https://leetcode.com/problems/additive-number/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl4.lc0306;

public class SolutionApproach0Backtrack1 {
    public boolean isAdditiveNumber(String num) {
        final int L = num.length();
        
        for(int i = 1; i <= (L - 1) / 2; i++){
            if(num.charAt(0) == '0' && i >= 2) break;
            
            for(int j = i + 1; L - j >= j - i && L - j >= i; j++){
                if(num.charAt(i) == '0' && j - i >= 2) break;
                
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String substr = num.substring(j);
                
                if(isAdditive(substr, num1, num2)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isAdditive(String str, long num1, long num2){
        if(str.equals("")) return true;
        
        long sum = num1 + num2;
        String s = Long.toString(sum);
        if(!str.startsWith(s)) return false;
        return isAdditive(str.substring(s.length()), num2, sum);
    }
}