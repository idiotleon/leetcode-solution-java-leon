/**
 * https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution/227715
 */
package com.zea7ot.leetcode.lvl5.lc0772;

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionApproach0Recursion1 {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        Queue<Character> tokens = new ArrayDeque<Character>();
        for(char ch : s.toCharArray()) if(ch != ' ') tokens.offer(ch);
        tokens.offer('+');
        
        return calculate(tokens);
    }
    
    private int calculate(Queue<Character> tokens){
        char prevOp = '+';
        int num = 0, sum = 0, prev = 0;
        
        while(!tokens.isEmpty()){
            char ch = tokens.poll();
            
            if('0' <= ch && ch <= '9') num = num * 10 + ch - '0';
            else if(ch == '(') num = calculate(tokens);
            else{
                switch(prevOp){
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }
                
                if(ch == ')') break;
                prevOp = ch;
                num = 0;
            }
        }
        
        return sum + prev;
    }
}