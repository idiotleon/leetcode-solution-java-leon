/**
 * https://leetcode.com/problems/simplify-path/
 */
package main.java.lcidiot.lc.lvl3.lc0071;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        // sanity check
        if(path == null || path.length() == 0) return path;
        
        String[] splitted = path.split("/", -1);
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < splitted.length; i++){
            if(splitted[i].trim().length() == 0)
                continue;
            
            if(splitted[i].equals("..")){
                if(!stack.isEmpty()) stack.pop();
                
                continue;
            }
            
            if(!splitted[i].equals("."))
                stack.push(splitted[i]);
        }
        
        if(stack.isEmpty()) return "/";
        
        String output = "";
        while(!stack.isEmpty()){
            String t = stack.pop();
            output = "/" + t + output;
        }
        
        return output;
    }
}