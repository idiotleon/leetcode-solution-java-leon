/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
package main.java.lcidiot.lc1249;

import java.util.Stack;

class SolutionApproachStack{
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < builder.length(); i++){
            if(builder.charAt(i) == '('){
                stack.add(i);
            }
            
            if(builder.charAt(i) == ')'){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    builder.setCharAt(i, '*');
                }
            }
        }
        
        while(!stack.empty()){
            builder.setCharAt(stack.pop(), '*');
        }
        
        return builder.toString().replaceAll("\\*", "");
    }
}