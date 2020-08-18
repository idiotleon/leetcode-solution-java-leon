/**
 * https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution
 */
package com.zea7ot.leetcode.lvl5.lc0772;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionApproach0Recursion2 {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        Queue<Character> queue = new LinkedList<Character>();
        for(char ch : s.toCharArray()) queue.offer(ch);
        
        queue.offer('+');
        return calculate(queue);
    }
    
    private int calculate(Queue<Character> queue){
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.isEmpty()){
            char ch = queue.poll();
            if(ch == ' ') continue;
            if(Character.isDigit(ch)) num = 10 * num + ch - '0';
            else if(ch == '(') num = calculate(queue);
            else{
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop() * num);
                else if(sign == '/') stack.push(stack.pop() / num);
                num = 0;
                sign = ch;
                if(ch == ')') break;
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();
        return sum;
    }
}