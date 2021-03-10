/**
 * https://leetcode.com/problems/score-of-parentheses/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space
 */
package com.an7one.leetcode.lvl3.lc0856;

import java.util.Stack;

public class SolutionApproachStack {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        int cur = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(cur);
                // to reset the counter
                cur = 0;
            }else{
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        
        return cur;
    }
}