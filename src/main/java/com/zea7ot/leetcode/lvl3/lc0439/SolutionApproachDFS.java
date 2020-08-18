/**
 * https://leetcode.com/problems/ternary-expression-parser/
 */
package com.zea7ot.leetcode.lvl3.lc0439;

public class SolutionApproachDFS {
    private int idx;
    
    public String parseTernary(String expression) {
        this.idx = 0;
        return Character.toString(dfs(expression));
    }
    
    private char dfs(String str){
        char cur = str.charAt(idx);
        if(idx + 1 == str.length() || str.charAt(idx + 1) == ':'){
            idx += 2; // to skip ':'
            return cur;
        }
        
        idx += 2;   // to skip '?'
        char left = dfs(str), right = dfs(str);
        return cur == 'T' ? left : right;
    }
}