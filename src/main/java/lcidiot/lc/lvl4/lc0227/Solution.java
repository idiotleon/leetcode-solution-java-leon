/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
package main.java.lcidiot.lc.lvl4.lc0227;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char op = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            
            if((!Character.isDigit(c) && ' ' != c) 
               || i == s.length() - 1){
                if(op == '-') stack.push(-num);
                if(op == '+') stack.push(num);
                if(op == '*') stack.push(stack.pop() * num);
                if(op == '/') stack.push(stack.pop() / num);
                
                op = c;
                num = 0;
            }
        }
        
        int ans = 0;
        for(int i : stack) {
            ans += i;
        }
        
        return ans;
    }
}