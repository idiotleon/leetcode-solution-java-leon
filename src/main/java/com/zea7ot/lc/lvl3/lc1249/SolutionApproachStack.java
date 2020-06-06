/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
package com.zea7ot.lc.lvl3.lc1249;

import java.util.LinkedList;
import java.util.Stack;

public class SolutionApproachStack{
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder(s);
        LinkedList<Integer> idxStack = new LinkedList<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                idxStack.offer(i);
            }
            
            if(s.charAt(i) == ')'){
                if(idxStack.isEmpty()){
                    builder.setCharAt(i, '*');
                }else{
                    idxStack.removeFirst();
                }
            }
        }
        
        while(!idxStack.isEmpty()){
            builder.setCharAt(idxStack.removeFirst(), '*');
        }
        
        return builder.toString().replaceAll("\\*", "");
    }

    public String minRemoveToMakeValid2(String s) {
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