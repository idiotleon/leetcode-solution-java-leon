/**
 * https://leetcode.com/problems/solve-the-equation/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/solve-the-equation/discuss/105311/Concise-Java-Solution/107968
 *  https://leetcode.com/problems/solve-the-equation/discuss/105311/Concise-Java-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0640;

public class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluateExpression(parts[0]);
        int[] right = evaluateExpression(parts[1]);
        
        if(left[0] == right[0] && left[1] == right[1]) return "Infinite solutions";
        else if(left[0] == right[0]) return "No solution";
        
        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }
    
    private int[] evaluateExpression(String exp){
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2]; // coefficients for x; 
        
        for(String token : tokens){
            if(token.equals("+x") || token.equals("x")) ++res[0]; // x means 1x
            else if(token.equals("-x")) --res[0]; // -x menas -1x
            else if(token.contains("x")) 
                res[0] += Integer.parseInt(token.substring(0, token.length() - 1));
            else res[1] += Integer.parseInt(token);
        }
        
        return res;
    }
}