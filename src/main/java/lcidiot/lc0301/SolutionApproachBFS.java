/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
 * Time Complexity: T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
 */
package main.java.lcidiot.lc0301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class SolutionApproachBFS {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) return res;
        
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!queue.isEmpty()){
            s = queue.poll();
            
            if(isValid(s)){
                res.add(s);
                found = true;
            }
            
            if(found) continue;
            
            // to generate all possible states
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                
                String t = s.substring(0, i) + s.substring(i + 1);
                
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        
        return res;
    }
    
    private boolean isValid(String str){
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(') count++;
            if(c == ')' && count-- == 0) return false;
        }
        
        return count == 0;
    }
}