/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
package main.java.lcidiot.lc.lvl3.lc0150;
import java.util.Stack;

public class SolutionApproachStack{
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens)
            if(token.equals("+")) 
                stack.add(stack.pop() + stack.pop());
            else if(token.equals("/")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }else if(token.equals("*"))
                stack.add(stack.pop() * stack.pop());
            else if(token.equals("-")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }else stack.add(Integer.parseInt(token));
        
        return stack.pop();
    }
 }