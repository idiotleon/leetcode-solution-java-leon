/**
 * https://leetcode.com/problems/ternary-expression-parser/
 */
package com.zea7ot.leetcode.lvl3.lc0439;

import java.util.LinkedList;

public class SolutionApproachStack {
    public String parseTernary(String expression) {
        if(expression == null || expression.isEmpty()) return "";
        
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(int i = expression.length() - 1; i >= 0; i--){
            char cur = expression.charAt(i);
            if(!stack.isEmpty() && stack.peekLast() == '?'){
                stack.removeLast(); // to pop out '?'
                char left = stack.removeLast();
                stack.removeLast(); // to pop out ':'
                char right = stack.removeLast();
                
                if(cur == 'T') stack.add(left);
                else stack.add(right);
            }else{
                stack.add(cur);
            }
        }
        
        return String.valueOf(stack.peekLast());
    }
}