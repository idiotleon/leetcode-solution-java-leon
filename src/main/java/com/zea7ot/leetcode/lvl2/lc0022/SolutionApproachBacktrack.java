/**
 * https://leetcode.com/problems/generate-parentheses/
 */
package com.zea7ot.leetcode.lvl2.lc0022;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachBacktrack {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if(n < 1) return ans;
        
        backtrack("", 0, 0, n, ans);
        
        return ans;
    }
    
    private void backtrack(String intermediate, 
                           int leftCnt, 
                           int rightCnt, 
                           int n,
                           List<String> ans){
        if(intermediate.length() == 2 * n){
            ans.add(intermediate);
            return;
        }
        
        if(leftCnt < n) {
            backtrack(intermediate + '(', leftCnt + 1, rightCnt, n, ans);
        }
        
        if(rightCnt < leftCnt){
            backtrack(intermediate + ')', leftCnt, rightCnt + 1, n, ans);
        }
    }
}