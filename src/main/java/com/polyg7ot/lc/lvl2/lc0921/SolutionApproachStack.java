/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
package com.polyg7ot.lc.lvl2.lc0921;

public class SolutionApproachStack {
    public int minAddToMakeValid(String S) {
        // sanity check
        if(S == null || S.isEmpty()) return 0;
                
        int ans = 0, stack = 0;
        for(int i = 0; i < S.length(); i++){
            char cur = S.charAt(i);
            
            if(cur == '('){
                stack++;
            }else if(cur == ')'){
                if(stack == 0) ans++;
                else stack--;
            }
        }
        
        ans += stack;
        
        return ans;
    }
}