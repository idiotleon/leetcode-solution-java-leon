/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl4.lc0636;

import java.util.List;
import java.util.Stack;

public class SolutionApproachStack2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[n];
        String[] str = logs.get(0).split(":");
        stack.push(Integer.parseInt(str[0]));
        int prev = Integer.parseInt(str[2]);
        
        for(int i = 1; i < logs.size(); i++){
            str = logs.get(i).split(":");
            if(str[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += Integer.parseInt(str[2]) - prev;
                }
                stack.push(Integer.parseInt(str[0]));
                prev = Integer.parseInt(str[2]);
            }else{
                res[stack.peek()] += Integer.parseInt(str[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(str[2]) + 1;
            }
        }
        
        return res;
    }
}