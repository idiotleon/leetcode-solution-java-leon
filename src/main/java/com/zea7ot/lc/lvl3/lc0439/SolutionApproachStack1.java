/**
 * https://leetcode.com/problems/ternary-expression-parser/
 */
package com.zea7ot.lc.lvl3.lc0439;

public class SolutionApproachStack1 {
    public String parseTernary(String expression) {
        StringBuilder resBuilder = new StringBuilder();
        StringBuilder opBuilder = new StringBuilder();
        
        for(int i = 0; i < expression.length(); i++){
            char cur = expression.charAt(i);
            
            if(Character.isDigit(cur) || cur == 'T' || cur == 'F'){
                resBuilder.append(cur);
            }else if(cur == '?'){
                opBuilder.append(cur);
            }else if(cur == ':'){
                if(opBuilder.charAt(opBuilder.length() - 1) == '?'){
                    opBuilder.append(cur);
                }else{
                    parseTernary(resBuilder, opBuilder);
                    opBuilder.append(cur);
                }
            }
        }
        
        parseTernary(resBuilder, opBuilder);
        return resBuilder.toString();
    }
    
    private void parseTernary(StringBuilder resBuilder, 
                              StringBuilder opBuilder){
        while(opBuilder.length() > 0 
              && opBuilder.charAt(opBuilder.length() - 1) == ':'){
            char right = resBuilder.charAt(resBuilder.length() - 1);
            resBuilder.deleteCharAt(resBuilder.length() - 1);
            
            char left = resBuilder.charAt(resBuilder.length() - 1);
            resBuilder.deleteCharAt(resBuilder.length() - 1);
            
            char condition = resBuilder.charAt(resBuilder.length() - 1);
            resBuilder.deleteCharAt(resBuilder.length() - 1);
            
            if(condition == 'T') resBuilder.append(left);
            else resBuilder.append(right);
            
            opBuilder.deleteCharAt(opBuilder.length() - 1);
            opBuilder.deleteCharAt(opBuilder.length() - 1);
        }
    }
}