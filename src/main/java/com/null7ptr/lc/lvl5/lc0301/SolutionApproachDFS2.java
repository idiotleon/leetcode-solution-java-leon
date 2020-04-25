/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
package com.null7ptr.lc.lvl5.lc0301;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        dfs(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    
    private void dfs(String str, List<String> ans, int iLast, int jLast, char[] par){
        for(int stack = 0, i = iLast; i < str.length(); ++i){
            if(str.charAt(i) == par[0]) stack++;
            if(str.charAt(i) == par[1]) stack--;
            if(stack >= 0) continue;
            
            for(int j = jLast; j <= i; ++j){
                if(str.charAt(j) == par[1] && (j == jLast || str.charAt(j - 1) != par[1])){
                    dfs(str.substring(0, j) + str.substring(j + 1), ans, i, j, par);
                }
            }
            
            return;
        }
        
        String reversed = new StringBuilder(str).reverse().toString();
        if(par[0] == '('){
            dfs(reversed, ans, 0, 0, new char[]{')', '('});
        }else{
            ans.add(reversed);
        }
    }
}