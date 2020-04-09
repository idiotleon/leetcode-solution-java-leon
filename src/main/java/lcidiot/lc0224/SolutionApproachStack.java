/**
 * https://leetcode.com/problems/basic-calculator/
 */
package main.java.lcidiot.lc0224;

import java.util.Stack;

public class SolutionApproachStack {
    public int calculate(String s) {
        if(s == null) return 0;
        
        int result = 0, sign = 1, num = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if(c == '+' || c == '-'){
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            }else if(c == '('){
                stack.push(sign);
            }else if(c == ')'){
                stack.pop();
            }
        }
        
        result += sign * num;
        return result;
    }
}