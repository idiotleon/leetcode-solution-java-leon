/**
 * https://leetcode.com/problems/add-digits/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl1.lc0258;

public class SolutionApproach1DFSRecursivel {
    public int addDigits(int num) {
        String n = Integer.toString(num);
        if(n.length() == 1) return Integer.parseInt(n);
        
        int sum = 0;
        for(char ch : n.toCharArray()){
            sum += Character.getNumericValue(ch);
        }
        return addDigits(sum);
    }
}