/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl4.lc0636;

import java.util.LinkedList;
import java.util.List;

public class SolutionApproachStack1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int[] ans = new int[n];
        String[] log = logs.get(0).split(":");
        stack.add(Integer.parseInt(log[0]));
        int prev = Integer.parseInt(log[2]);
        
        for(int i = 1; i < logs.size(); i++){
            log = logs.get(i).split(":");
            if(log[1].equals("start")){
                if(!stack.isEmpty()){
                    ans[stack.peekLast()] += Integer.parseInt(log[2]) - prev;
                }
                stack.add(Integer.parseInt(log[0]));
                prev = Integer.parseInt(log[2]);
            }else{
                ans[stack.peekLast()] += Integer.parseInt(log[2]) - prev + 1;
                stack.removeLast();
                prev = Integer.parseInt(log[2]) + 1;
            }
        }
        
        return ans;
    }
}